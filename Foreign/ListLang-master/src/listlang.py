#!/usr/bin/env python
# -*- coding: utf-8 -*-
from llcompiler import error_processor, ListLangParser, ListLangWalker, ListLangLexer

__author__ = 'Oleg Beloglazov'


import sys
import os
import argparse
import subprocess
import shutil
import zipfile

import antlr3
import antlr3.tree


def tokens_out(tokens, tokens_filename):
    dir_name = os.path.dirname(tokens_filename)
    if not os.path.exists(dir_name):
        os.makedirs(dir_name)
    tokens_file = open(tokens_filename, 'w')

    for token in tokens:
        tokens_file.write('%3s |%3s: %s\n' %
                          (str(token.getTokenIndex()),
                           str(token.getType()),
                           repr(token.getText()))
        )
    tokens_file.close()


def make_jasmin_file(src_filename, dest_filename, tokens_filename=''):
    # Run lexer
    char_stream = antlr3.ANTLRFileStream(src_filename, encoding='utf8')
    lexer = ListLangLexer.ListLangLexer(char_stream)
    tokens = antlr3.CommonTokenStream(lexer)

    if tokens_filename:
        tokens_out(tokens.getTokens(), tokens_filename)

    # Get AST tree
    parser = ListLangParser.ListLangParser(tokens)
    ast = parser.program().tree

    #print ast.toStringTree()

    errors = error_processor.get_all_errors()
    if errors:
        sys.stderr.write('\n'.join(errors))
        sys.exit(1)

    nodes = antlr3.tree.CommonTreeNodeStream(ast)
    nodes.setTokenStream(tokens)

    walker = ListLangWalker.ListLangWalker(nodes)

    try:
        target_code = walker.program()
    except error_processor.SemanticException as e:
        error_processor.add_error(error_processor.SEMANTIC, e.line, e.pos_in_line, e.message)

    errors = error_processor.get_all_errors()
    if errors:
        sys.stderr.write('\n'.join(errors))
        sys.exit(1)

    if target_code:
        target_file = open(dest_filename, 'w')
        target_file.write(target_code)
        target_file.close()


def get_dir_files_paths(dir_path, recursive=False):
    child_paths = [os.path.join(dir_path, file) for file in os.listdir(dir_path)]

    files_paths = []
    if child_paths:
        for path in child_paths:
            if os.path.isdir(path) and recursive:
                files_paths += get_dir_files_paths(path, recursive)
            elif os.path.isfile(path):
                files_paths.append(path)
            else:
                pass

    return files_paths


def cmd(args):
    try:
        output = subprocess.check_output(args, stderr=subprocess.STDOUT, shell=True)
    except subprocess.CalledProcessError as e:
        output = e.output
    return output


def zipfile_add_directory(zip_file, target_dir):
    rootlen = len(target_dir)
    for base, dirs, files in os.walk(target_dir):
        for file in files:
            fn = os.path.join(base, file)
            zip_file.write(fn, fn[rootlen:])

def main():
    # Parse command line arguments
    args_parser = argparse.ArgumentParser(description='Compile listlang source files.')
    args_parser.add_argument('src_filename', type=str, help='path to source file')
    args_parser.add_argument('dest_filename', type=str, help='path to output compiled file')
    args_parser.add_argument('--tokens', '-t', dest='tokens_filename', help='get file with tokens')
    args = args_parser.parse_args()

    BUILDING_DIR = 'tmp/lljar/'
    JFILENAME = BUILDING_DIR + 'target.j'

    # prepare building directory
    if os.path.exists(BUILDING_DIR):
        shutil.rmtree(BUILDING_DIR)
    shutil.copytree('adds', BUILDING_DIR)

    # make target file with jasmin code
    make_jasmin_file(args.src_filename, JFILENAME, args.tokens_filename)

    # compile jasmin file
    cmd(r'java -jar jasmin.jar -d %s %s' % (BUILDING_DIR, JFILENAME))
    os.remove(JFILENAME)

    # make jar file
    print 'creating jar file'
    zf = zipfile.ZipFile(args.dest_filename, mode='w')
    zipfile_add_directory(zf, BUILDING_DIR)
    zf.close()


if __name__ == "__main__":
    main()
#!/usr/bin/env python
# -*- coding: utf-8 -*-

__author__ = 'Oleg Beloglazov'

from globals import *


class JCodeMaker:

    CLASS_HEADER = '''.class public %s
.super java/lang/Object
''' % TARGET_CLASS_NAME

    CLASS_INIT = '''.method public <init>()V
    aload_0
    invokespecial java/lang/Object/<init>()V
    return
.end method
'''

    BUILTIN_METHODS = '''; void print(int)
.method public static print(I)V
    .limit locals 5
    .limit stack 5
    iload 0
    getstatic java/lang/System/out Ljava/io/PrintStream;
    swap
    invokevirtual java/io/PrintStream/print(I)V
    return
.end method

; void print(string)
.method public static print(Ljava/lang/String;)V
    .limit locals 5
    .limit stack 5
    aload 0
    getstatic java/lang/System/out Ljava/io/PrintStream;
    swap
    invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
    return
.end method



; int neg(int)
.method public static neg(I)I
    .limit locals 5
    .limit stack 5
    iload 0
    ifeq RET_1
    ldc 0
    ireturn
    RET_1:
    ldc 1
    ireturn
.end method
'''

    JMETHOD_TEMPLATE = '''.method public static %s(%s)%s
\t.limit stack %i
\t.limit locals %i
\t%s
.end method

'''  # args: name, params, return_jtype, stack_size, locals_number, code

    def __init__(self):
        self.list = ListJavaMediator(self)

        self.commands = []
        self.return_jtype = VOID_JTYPE
        self.return_label = 'RETURN_LABEL'
        self.label_counter = 0
        self.fields = []
        self.stack_size = 0

    def make_class(self, stack_size, locals_number, methods_code):
        """ Make Jasmin class with using commands of this maker for main method """
        fields = '\n'.join(self.fields) + '\n'
        bultin_functions_jcode = '\n'.join([func_jcode[2] for func_jcode in BUILTIN_FUNCTIONS.values()])
        return (self.CLASS_HEADER +
                fields +
                self.CLASS_INIT +
                self.make_method('main', ['[Ljava/lang/String;'], stack_size, locals_number) +
                methods_code +
                self.BUILTIN_METHODS +
                bultin_functions_jcode
        )

    def make_method(self, name, params_jtypes, stack_size, locals_number):
        """ Returns code of method with code maked by this maker """
        # add return
        self.command_label(self.return_label)
        if self.stack_size == 0 and self.return_jtype != VOID_JTYPE:
            if self.return_jtype == INTEGER_JTYPE:
                self.command_ldc(0)
            elif self.return_jtype == INTEGER_LIST_JTYPE:
                self.command_new(INTEGER_LIST_CLASS)
                self.command_dup()
                self.command_invokespecial(INTEGER_LIST_CLASS, '<init>', [], VOID_JTYPE)

        self.command_return()

        # move locals of method args
        self.add_command('', add_first=True)
        for i, param_jtype in enumerate(params_jtypes):
            # reverse order of calls since adding first
            self.command_store(param_jtype, RESERVED_LOCALS + i, add_first=True)
            if param_jtype == INTEGER_LIST_JTYPE:
                self.command_invokevirtual(INTEGER_LIST_CLASS, 'clone', [], INTEGER_LIST_JTYPE, add_first=True)
            self.command_load(param_jtype, i, add_first=True)


        code = '\n\t'.join(self.commands)
        return self.JMETHOD_TEMPLATE % (name, ''.join(params_jtypes), self.return_jtype, stack_size, locals_number+1, code)

    def make_label(self, scope_number, name):
        self.label_counter += 1
        return 'S%iL%i_%s' % (scope_number, self.label_counter, name)

    def add_static_field(self, name, jtype):
        field = '.field static %s %s' % (name, jtype)
        self.fields.append(field)

    def make_field_name(self, name):
        return 'global__' + name

    def add_command(self, command, add_first=False):
        if add_first:
            self.commands.insert(0, command)
        else:
            self.commands.append(command)

    # COMMANDS

    def command_ldc(self, value):
        """ Jasmin command to load constant on stack """
        command =  'ldc %s' % value
        self.add_command(command)
        self.stack_size += 1

    def command_store(self, value_jtype, var_number, add_first=False):
        """ Jasmin command to pop from stack var and store it in variable """
        instruction = 'istore' if value_jtype == INTEGER_JTYPE else 'astore'
        command =  '%s %s' % (instruction, var_number)
        self.add_command(command, add_first=add_first)
        self.stack_size -= 1

    def command_load(self, value_jtype, var_number, add_first=False):
        """ Jasmin command to push variable to stack """
        instruction =  'iload' if value_jtype == INTEGER_JTYPE else 'aload'
        command = '%s %s' % (instruction, var_number)
        self.add_command(command, add_first=add_first)
        self.stack_size += 1

    def command_return(self):
        """ Jasmin method return command """
        if self.return_jtype == INTEGER_JTYPE:
            instruction = 'ireturn'
        elif self.return_jtype == INTEGER_LIST_JTYPE:
            instruction = 'areturn'
        else:
            instruction = 'return'
        command = instruction
        self.add_command(command)
        self.stack_size -= 1
        self.return_added = True

    def command_new(self, full_class_name):
        """ Jasmin command new """
        command = 'new ' + full_class_name
        self.add_command(command)
        self.stack_size += 1

    def command_dup(self):
        """ Jasmin command to duplicate top value on stack """
        self.add_command('dup')
        self.stack_size += 1

    def command_pop(self):
        """ Jasmin command to pop top value from stack """
        self.add_command('pop')
        self.stack_size -= 1

    def command_swap(self):
        """ Jasmin command to swap two values on top """
        self.add_command('swap')

    def command_invokespecial(self, full_class_name, method, jparams, return_jtype):
        """ Jasmin command to invoke special methods of objects (constructors, ...) """
        self.command_invoke('invokespecial', full_class_name, method, jparams, return_jtype)
        self.stack_size -= len(jparams) + 1

    def command_invokevirtual(self, full_class_name, method, jparams, return_jtype, add_first=False):
        """ Jasmin command to invoke virtual methods of objects """
        self.command_invoke('invokevirtual', full_class_name, method, jparams, return_jtype, add_first=add_first)
        self.stack_size -= len(jparams) + 1

    def command_invokestatic(self, full_class_name, method, jparams, return_jtype):
        """ Jasmin command to invoke static methods """
        self.command_invoke('invokestatic', full_class_name, method, jparams, return_jtype)
        self.stack_size -= len(jparams)

    def command_invoke(self, invoke_instr, full_class_name, method, jparams, return_jtype, add_first=False):
        command = '%s %s/%s(%s)%s' % (invoke_instr, full_class_name, method, ''.join(jparams), return_jtype)
        self.add_command(command, add_first=add_first)
        if return_jtype != VOID_JTYPE:
            self.stack_size += 1

    def command_ifgt(self, label):
        self.add_command('ifgt ' + label)
        self.stack_size -= 1

    def command_ifne(self, label):
        self.add_command('ifne ' + label)
        self.stack_size -= 1

    def command_ifeq(self, label):
        self.add_command('ifeq ' + label)
        self.stack_size -= 1

    def command_goto(self, label):
        self.add_command('goto ' + label)

    def command_if_icmpeq(self, label):
        self.add_command('if_icmpeq ' + label)
        self.stack_size -= 2

    def command_if_icmplt(self, label):
        self.add_command('if_icmplt ' + label)
        self.stack_size -= 2

    def command_if_icmpge(self, label):
        self.add_command('if_icmpge ' + label)
        self.stack_size -= 2

    def command_if_icmpgt(self, label):
        self.add_command('if_icmpgt ' + label)
        self.stack_size -= 2

    def command_if_icmple(self, label):
        self.add_command('if_icmple ' + label)
        self.stack_size -= 2

    def command_label(self, label):
        self.add_command('\n%s:' % label)

    def command_iadd(self):
        self.add_command('iadd')
        self.stack_size -= 1

    def command_isub(self):
        self.add_command('isub')
        self.stack_size -= 1

    def command_imul(self):
        self.add_command('imul')
        self.stack_size -= 1

    def command_idiv(self):
        self.add_command('idiv')
        self.stack_size -= 1

    def command_irem(self):
        self.add_command('irem')
        self.stack_size -= 1

    def command_ineg(self):
        self.add_command('ineg')

    def command_comment(self, comment):
        self.add_command('\n\t; %s; stack=%i' % (comment, self.stack_size))

    def command_putstatic(self, jclass, field, jtype):
        self.add_command('putstatic %s/%s %s' % (jclass, field, jtype))
        self.stack_size -= 1

    def command_getstatic(self, jclass, field, jtype):
        self.add_command('getstatic %s/%s %s' % (jclass, field, jtype))
        self.stack_size += 1


BUILTIN_FUNCTIONS = {

    'len': (ELEMENT, [LIST],
        '''.method public static len(Llistlang/objects/List;)I
    .limit locals 5
    .limit stack 5
    aload 0
    invokevirtual listlang/objects/List/len()I
    ireturn
.end method'''),

    'count': (ELEMENT, [LIST, ELEMENT],
            '''.method public static count(Llistlang/objects/List;I)I
        .limit locals 5
        .limit stack 5
        aload 0
        iload 1
        invokevirtual listlang/objects/List/count(I)I
        ireturn
    .end method'''),

    'read_element': (ELEMENT, [], '''.method public static read_element()I
    .limit locals 10
    .limit stack 10

    new java/util/Scanner
	dup
	getstatic java/lang/System/in Ljava/io/InputStream;
	invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V
	invokevirtual java/util/Scanner/nextInt()I

    ireturn
.end method'''),

     'read_list': (LIST, [], '''.method public static read_list()Llistlang/objects/List;
    .limit locals 10
    .limit stack 10

	invokestatic listlang/objects/List/read()Llistlang/objects/List;

    areturn
.end method''')

}


class ListJavaMediator:

    def __init__(self, code_maker):
        self.code_maker = code_maker

    def len(self):
        self.code_maker.command_invokevirtual(INTEGER_LIST_CLASS, 'len', [], INTEGER_JTYPE)

    def get(self):
        self.code_maker.command_invokevirtual(INTEGER_LIST_CLASS, 'get', [INTEGER_JTYPE], INTEGER_JTYPE)

    def to_int(self):
        self.code_maker.command_invokevirtual(INTEGER_LIST_CLASS, 'to_int', [], INTEGER_JTYPE)

    def print_list(self):
        self.code_maker.command_invokevirtual(INTEGER_LIST_CLASS, 'print', [], VOID_JTYPE)

    def equal(self):
        self.code_maker.command_invokevirtual(INTEGER_LIST_CLASS, 'equal', [INTEGER_LIST_JTYPE], INTEGER_JTYPE)

    def concat(self):
        self.code_maker.command_invokevirtual(INTEGER_LIST_CLASS, 'concat', [INTEGER_LIST_JTYPE], INTEGER_LIST_JTYPE)

    def addFirst(self):
        self.code_maker.command_invokevirtual(INTEGER_LIST_CLASS, 'addFirst', [INTEGER_JTYPE], VOID_JTYPE)

    def addLast(self):
        self.code_maker.command_invokevirtual(INTEGER_LIST_CLASS, 'addLast', [INTEGER_JTYPE], VOID_JTYPE)

    def multiply(self):
        self.code_maker.command_invokevirtual(INTEGER_LIST_CLASS, 'multiply', [INTEGER_JTYPE], INTEGER_LIST_JTYPE)

    def removeEvery(self):
        self.code_maker.command_invokevirtual(INTEGER_LIST_CLASS, 'removeEvery', [INTEGER_JTYPE], INTEGER_LIST_JTYPE)

    def delete(self):
        self.code_maker.command_invokevirtual(INTEGER_LIST_CLASS, 'delete', [INTEGER_JTYPE], VOID_JTYPE)

    def removeFirst(self):
        self.code_maker.command_invokevirtual(INTEGER_LIST_CLASS, 'removeFirst', [], VOID_JTYPE)

    def removeLast(self):
        self.code_maker.command_invokevirtual(INTEGER_LIST_CLASS, 'removeLast', [], VOID_JTYPE)

    def clone(self):
        self.code_maker.command_invokevirtual(INTEGER_LIST_CLASS, 'clone', [], INTEGER_LIST_JTYPE)

    def new(self):
        self.code_maker.command_new(INTEGER_LIST_CLASS)
        self.code_maker.command_dup()
        self.code_maker.command_invokespecial(INTEGER_LIST_CLASS, '<init>', [], VOID_JTYPE)

    def slice(self):
        self.code_maker.command_invokevirtual(
            INTEGER_LIST_CLASS, 'slice', [INTEGER_JTYPE, INTEGER_JTYPE], INTEGER_LIST_JTYPE
        )


class StackCleaner:

    def __init__(self, code_maker):
        self.code_maker = code_maker
        self.stack_size = code_maker.stack_size

    def cleanup(self):
        self.code_maker.command_comment('start cleanup')
        while self.code_maker.stack_size > self.stack_size:
            self.code_maker.command_pop()
        self.code_maker.command_comment('end cleanup')

    def cleanall(self):
        while self.code_maker.stack_size > 0:
            self.code_maker.command_pop()
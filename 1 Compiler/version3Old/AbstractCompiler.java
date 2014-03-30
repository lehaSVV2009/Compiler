package com.kadet.compiler;

import org.antlr.runtime.tree.CommonTree;

/**
 * Date: 27.02.14
 * Time: 1:27
 *
 * @author SarokaA
 */
public abstract class AbstractCompiler {

    public abstract CommonTree compile (String expression);

    protected void printTree (CommonTree ast) {
        print(ast, 0);
    }

    private void print (CommonTree tree, int level) {
        //indent level
        for (int i = 0; i < level; i++)
            System.out.print("--");

        //print node description: type code followed by token text
        System.out.println(" " + tree.getType() + " " + tree.getText());

        //print all children
        if (tree.getChildren() != null)
            for (Object ie : tree.getChildren()) {
                print((CommonTree) ie, level + 1);
            }
    }

}

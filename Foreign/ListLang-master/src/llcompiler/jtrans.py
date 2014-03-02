#!/usr/bin/env python
# -*- coding: utf-8 -*-

__author__ = 'Oleg Beloglazov'

import error_processor, jcodemaker
from globals import *


class JTranslator:

    DEFAULT_STACK_SIZE = 100

    def __init__(self):
        self.functions_jcode = []
        self.scopes_stack = []
        self.walker = None
        
        self.while_stack = []
        self.for_stack = []
        self.if_stack = []

    def enter_scope(self, scope):
        self.scopes_stack.append(scope)
        self.scope = scope
        self.code_maker = self.scope.code_maker

    def leave_scope(self):
        self.scopes_stack.pop()
        if self.scopes_stack:
            self.scope = self.scopes_stack[-1]
            self.code_maker = self.scope.code_maker
        else:
            self.scope = None
            self.code_maker = None

    def get_rule_position(self):
        """ Return (line, position_in_line) of begin of current rule """
        symbol = self.walker.input.LT(-1)
        if symbol.parent:
            symbol = symbol.parent.children[0]
        return symbol.getLine(), symbol.getCharPositionInLine()

    def get_var_number(self, var_id):
        try:
            var_number = self.scope.vars.index(var_id)
        except ValueError:
            raise error_processor.UnsupportedOperation(
                self.get_rule_position(),
                'Undefined ID "%s".' % var_id
            )
        return RESERVED_LOCALS + var_number

    # RULES

    def program(self):
        return self.code_maker.make_class(
            self.DEFAULT_STACK_SIZE, RESERVED_LOCALS + len(self.scope.vars), ''.join(self.functions_jcode)
        )

    def function(self, f_params, f_scope):
        f_id = f_scope.scope_name
        if f_id in jcodemaker.BUILTIN_FUNCTIONS:
            raise error_processor.BuiltinConflictException(
                self.get_rule_position(), 'Id "%s" is builtin function id.' % f_id
            )

        if f_id in self.scope.funcs:
            raise error_processor.FunctionConflictException(
                self.get_rule_position(), 'Function with id "%s" already exists in this scope.' % f_id
            )

        f_translated_params = [type_map[type] for id, type in f_params]
        f_jcode = f_scope.code_maker.make_method(
            self.scope.get_function_code_name(f_id), f_translated_params,
            self.DEFAULT_STACK_SIZE, RESERVED_LOCALS + len(f_scope.vars)
        )
        self.functions_jcode.append(f_jcode)

    def for_operation_begin(self, iter_id, value_type): # stack: 1
        if value_type != LIST:
            raise error_processor.UnsupportedOperation(
                self.get_rule_position(), '"for" operation with "in" type %s is unsupported' % value_type
            )

        for_begin_label = self.code_maker.make_label(self.scope.scope_number, 'FOR_BEGIN')
        for_end_label = self.code_maker.make_label(self.scope.scope_number, 'FOR_END')


        self.code_maker.command_comment('for_operation_begin')

        self.code_maker.command_ldc(0)  # iterator
        # stack: 2 (list, iter)
        self.code_maker.command_label(for_begin_label)
        self.code_maker.command_store(INTEGER_JTYPE, TEMPORARY_STORE_VAR_1)  # save iterator
        self.code_maker.command_dup()  # duplicate list
        self.code_maker.list.len()
        self.code_maker.command_load(INTEGER_JTYPE, TEMPORARY_STORE_VAR_1)
        # stack: 3 (list, list_len, iter)
        self.code_maker.command_if_icmple(for_end_label)
        # stack: 1 (list)
        self.code_maker.command_dup()  # duplicate list
        self.code_maker.command_load(INTEGER_JTYPE, TEMPORARY_STORE_VAR_1)
        self.code_maker.list.get()
        # stack: 2 (list, element)
        self.code_maker.command_load(INTEGER_JTYPE, TEMPORARY_STORE_VAR_1)
        self.code_maker.command_swap()
        # stack: 3 (list, iter, element)
        self.assignment_expr(iter_id, ELEMENT)
        # stack: 2 (list, iter)

        cleaner = jcodemaker.StackCleaner(self.code_maker)
        self.for_stack.append([for_begin_label, for_end_label, cleaner])

    def for_operation(self):
        for_begin_label, for_end_label, cleaner = self.for_stack.pop()

        self.code_maker.command_comment('for_operation_end')

        cleaner.cleanup()

        # stack: 2 (list, iter)
        self.code_maker.command_ldc(1)
        self.code_maker.command_iadd()
        # stack: 2 (list, iter)
        self.code_maker.command_goto(for_begin_label)

        self.code_maker.command_label(for_end_label)
        self.code_maker.stack_size -= 1
        # stack: 1 (list)
        self.code_maker.command_pop()   # pop out iterating list from stack

    def while_operation_begin(self): # stack: 0
        while_begin_label = self.code_maker.make_label(self.scope.scope_number, 'WHILE_BEGIN')
        while_end_label = self.code_maker.make_label(self.scope.scope_number, 'WHILE_END')

        self.code_maker.command_comment('while_operation_begin')
        self.code_maker.command_label(while_begin_label)
        # stack: 0

        self.while_stack.append([while_begin_label, while_end_label, None])
        
    def while_operation_value(self, value_type): # stack: 1
        while_end_label = self.while_stack[-1][1]

        self.code_maker.command_comment('while_operation_value')

        # stack: 1 (value)
        if value_type == LIST:
            self.code_maker.list.to_int()
        # stack: 1 (element)
            
        self.code_maker.command_ifeq(while_end_label)
        # stack: 0

        cleaner = jcodemaker.StackCleaner(self.code_maker)
        self.while_stack[-1][2] = cleaner

        
    def while_operation(self): # stack: 0
        while_begin_label, while_end_label, cleaner = self.while_stack.pop()

        self.code_maker.command_comment('while_operation')

        cleaner.cleanup()
        # stack: 0
        self.code_maker.command_goto(while_begin_label)

        self.code_maker.command_label(while_end_label)
        # stack: 0
        
    def if_operation_value(self, value_type, is_elif=False): # stack: 1
        else_label = self.code_maker.make_label(self.scope.scope_number, 'ELSE')

        self.code_maker.command_comment('if_operation_value')

        # stack: 1 (value)
        if value_type == LIST:
            self.code_maker.list.to_int()
        # stack: 1 (element)
            
        self.code_maker.command_ifeq(else_label)
        # stack: 0

        cleaner = jcodemaker.StackCleaner(self.code_maker)

        if is_elif:
            self.if_stack[-1][1] = else_label
            self.if_stack[-1][2] = cleaner
        else:
            if_end_label = self.code_maker.make_label(self.scope.scope_number, 'IF_END')
            self.if_stack.append([if_end_label, else_label, cleaner])

    def if_operation_else(self):
        if_end_label, else_label, cleaner = self.if_stack[-1]

        self.code_maker.command_comment('if_operation_else')
        cleaner.cleanup()

        # stack: 0
        self.code_maker.command_goto(if_end_label)

        self.code_maker.command_label(else_label)
        # stack: 0

    def if_operation(self):
        if_end_label, else_label, cleaner = self.if_stack.pop()

        self.code_maker.command_comment('if_operation')
        cleaner.cleanup()
        # stack: 0
        self.code_maker.command_label(if_end_label)

    def print_value(self, value_type):
        self.code_maker.command_comment('print_value ' + value_type)
        if value_type == ELEMENT:
            self.code_maker.command_invokestatic(TARGET_CLASS_NAME, 'print', [INTEGER_JTYPE], VOID_JTYPE)
        elif value_type == LIST:
            self.code_maker.list.print_list()
        self.code_maker.command_ldc('" "')
        self.code_maker.command_invokestatic(TARGET_CLASS_NAME, 'print', [STRING_JTYPE], VOID_JTYPE)

    def print_operation(self):
        self.code_maker.command_comment('print_operation')
        self.code_maker.command_ldc('"\\n"')
        self.code_maker.command_invokestatic(TARGET_CLASS_NAME, 'print', [STRING_JTYPE], VOID_JTYPE)

    def return_operation(self, value_type):
        if self.scope.is_global():
            required_stack_size = 0
        else:
            required_stack_size = 1
            if not value_type:
                self.code_maker.command_ldc(0)
            self.__set_function_return_type(value_type if value_type else ELEMENT)

        while self.code_maker.stack_size > required_stack_size:
            self.code_maker.command_pop()
        return_label = self.code_maker.return_label
        self.code_maker.command_goto(return_label)

    def __set_function_return_type(self, return_type):
        return_jtype = type_map[return_type]

        if self.code_maker.return_jtype == VOID_JTYPE:
            self.code_maker.return_jtype = return_jtype
            function_id = self.scope.scope_name
            self.scopes_stack[-2].set_function_return_type(function_id, return_type)

        elif self.code_maker.return_jtype != return_jtype:
            raise error_processor.ReturnTypeException(
                self.get_rule_position(),
                'Function must return object of type %s in "%s" scope.' % (
                    self.code_maker.return_jtype, self.scope.scope_name
                )
            )


    def global_operation(self, var_id):
        if self.scope.is_global():
            raise error_processor.GlobalOperationException(
                self.get_rule_position(),
                'using global operation for variable %s in global scope.' % var_id
            )
        if var_id not in self.scopes_stack[0].vars:
            raise error_processor.UndefinedIDException(
                self.get_rule_position(),
                'variable "%s" not defined in global scope.' % (var_id)
            )
        self.scope.add_global_var(var_id)

    def assignment_expr(self, var_id, value_type):
        if self.scope.is_global():
            field_name = self.code_maker.make_field_name(var_id)
            field_jtype = type_map[value_type]

            if not var_id in self.scope.vars:
                self.code_maker.add_static_field(field_name, field_jtype)
                self.scope.add_var(var_id, value_type)

            self.code_maker.command_putstatic(TARGET_CLASS_NAME, field_name, field_jtype)

        else:
            if not var_id in self.scope.vars:
                self.scope.add_var(var_id, value_type)

            if var_id in self.scope.global_vars:
                field_name = self.code_maker.make_field_name(var_id)
                field_jtype = type_map[value_type]

                self.code_maker.command_comment('assignment global %s = %s' % (var_id, value_type))
                self.code_maker.command_putstatic(TARGET_CLASS_NAME, field_name, field_jtype)
            else:
                self.code_maker.command_comment('assignment %s = %s' % (var_id, value_type))
                self.code_maker.command_store(type_map[value_type], self.get_var_number(var_id))

    # RVALUES (returns value type)

    def or_expr(self, type1, type2):
        self.code_maker.command_comment('or_expr %s or %s' % (type1, type2))
        if type2 == LIST:
            self.code_maker.list.to_int()
        if type1 == LIST:
            self.code_maker.command_swap()
            self.code_maker.list.to_int()
            self.code_maker.command_swap()

        true1_label = self.code_maker.make_label(self.scope.scope_number, 'OR_TRUE1')
        true2_label = self.code_maker.make_label(self.scope.scope_number, 'OR_TRUE2')
        or_end_label = self.code_maker.make_label(self.scope.scope_number, 'OR_END')

        self.code_maker.command_swap()
        self.code_maker.command_ifne(true1_label)
        self.code_maker.command_ifne(true2_label)
        self.code_maker.command_ldc(0)
        self.code_maker.command_goto(or_end_label)
        self.code_maker.command_label(true1_label)
        self.code_maker.command_pop()
        self.code_maker.command_label(true2_label)
        self.code_maker.command_ldc(1)
        self.code_maker.command_label(or_end_label)

        return ELEMENT

    def and_expr(self, type1, type2):
        self.code_maker.command_comment('and_expr %s and %s' % (type1, type2))
        if type2 == LIST:
            self.code_maker.list.to_int()
        if type1 == LIST:
            self.code_maker.command_swap()
            self.code_maker.list.to_int()
            self.code_maker.command_swap()

        false1_label = self.code_maker.make_label(self.scope.scope_number, 'AND_FALSE1')
        false2_label = self.code_maker.make_label(self.scope.scope_number, 'AND_FALSE')
        and_end_label = self.code_maker.make_label(self.scope.scope_number, 'AND_END')

        self.code_maker.command_swap()
        self.code_maker.command_ifeq(false1_label)
        self.code_maker.command_ifeq(false2_label)
        self.code_maker.command_ldc(1)
        self.code_maker.command_goto(and_end_label)
        self.code_maker.command_label(false1_label)
        self.code_maker.command_pop()
        self.code_maker.command_label(false2_label)
        self.code_maker.command_ldc(0)
        self.code_maker.command_label(and_end_label)

        return ELEMENT

    def equality_expr(self, operator, type1, type2):
        self.code_maker.command_comment('equality_expr %s %s %s' % (type1, operator, type2))
        if type1 == type2 == ELEMENT:
            eq_true_label = self.code_maker.make_label(self.scope.scope_number, 'EQ_TRUE')
            eq_end_label = self.code_maker.make_label(self.scope.scope_number, 'EQ_END')

            self.code_maker.command_if_icmpeq(eq_true_label)
            self.code_maker.command_ldc(0)
            self.code_maker.command_goto(eq_end_label)
            self.code_maker.command_label(eq_true_label)
            self.code_maker.command_ldc(1)
            self.code_maker.command_label(eq_end_label)

            self.code_maker.stack_size -= 1

        elif type1 == type2 == LIST:
            self.code_maker.list.equal()

        else:
            self.code_maker.command_pop()
            self.code_maker.command_pop()
            self.code_maker.command_ldc(0)

        if operator == '!=':
            self.not_expr(ELEMENT)

        return ELEMENT

    def relational_expr(self, operator, type1, type2):
        self.code_maker.command_comment('relational_expr %s %s %s' % (type1, operator, type2))
        if type1 == LIST or type2 == LIST:
            raise error_processor.UnsupportedOperation(
                self.get_rule_position(),
                'Relational operation (%s) for lists is unsupported.' % operator
            )

        rel_true_label = self.code_maker.make_label(self.scope.scope_number, 'REL_TRUE')
        rel_end_label = self.code_maker.make_label(self.scope.scope_number, 'REL_END')

        if operator == '<': self.code_maker.command_if_icmplt(rel_true_label)
        elif operator == '<=': self.code_maker.command_if_icmple(rel_true_label)
        elif operator == '>': self.code_maker.command_if_icmpgt(rel_true_label)
        elif operator == '>=': self.code_maker.command_if_icmpge(rel_true_label)

        self.code_maker.command_ldc(0)
        self.code_maker.command_goto(rel_end_label)
        self.code_maker.command_label(rel_true_label)
        self.code_maker.command_ldc(1)
        self.code_maker.command_label(rel_end_label)

        self.code_maker.stack_size -= 1

        return ELEMENT

    def additive_expr(self, operator, type1, type2):
        self.code_maker.command_comment('additive_expr %s %s %s' % (type1, operator, type2))
        if operator == '+':
            if type1 == type2 == ELEMENT:
                self.code_maker.command_iadd()
                return ELEMENT
            elif type1 == type2 == LIST:
                self.code_maker.list.concat()
                return LIST
            elif type1 == ELEMENT and type2 == LIST:
                self.code_maker.command_dup()
                self.code_maker.command_store(INTEGER_LIST_JTYPE, 0)
                self.code_maker.command_swap()
                self.code_maker.list.addFirst()
                self.code_maker.command_load(INTEGER_LIST_JTYPE, 0)
                return LIST
            elif type1 == LIST and  type2 == ELEMENT:
                self.code_maker.command_swap()
                self.code_maker.command_dup()
                self.code_maker.command_store(INTEGER_LIST_JTYPE, 0)
                self.code_maker.command_swap()
                self.code_maker.list.addLast()
                self.code_maker.command_load(INTEGER_LIST_JTYPE, 0)
                return LIST
        elif operator == '-':
            if type1 == type2 == ELEMENT:
                self.code_maker.command_isub()
                return ELEMENT
            else:
                raise error_processor.UnsupportedOperation(
                    self.get_rule_position(),
                    'Additive expression (%s %s %s) is unsupported.' % (type1, operator, type2)
                )

    def multiplicative_expr(self, operator, type1, type2):
        self.code_maker.command_comment('multiplicative_expr %s %s %s' % (type1, operator, type2))
        if operator == '*':
            if type1 == type2 == ELEMENT:
                self.code_maker.command_imul()
                return ELEMENT
            elif type1 == LIST and type2 == ELEMENT:
                self.code_maker.list.multiply()
                return LIST

        elif operator == '/':
            if type1 == type2 == ELEMENT:
                self.code_maker.command_idiv()
                return ELEMENT
            elif type1 == LIST and type2 == ELEMENT:
                self.code_maker.list.removeEvery()
                return LIST

        elif operator == '%':
            if type1 == type2 == ELEMENT:
                self.code_maker.command_irem()
                return ELEMENT
            elif type1 == LIST and type2 == ELEMENT:
                self.code_maker.command_swap()
                self.code_maker.command_dup()
                self.code_maker.command_store(INTEGER_LIST_JTYPE, 0)
                self.code_maker.command_swap()
                self.code_maker.list.delete()
                self.code_maker.command_load(INTEGER_LIST_JTYPE, 0)
                return LIST

        raise error_processor.UnsupportedOperation(
            self.get_rule_position(),
            'Multiplicative expression (%s %s %s) is unsupported.' % (type1, operator, type2)
        )
                                   
    def pre_incr_expr(self, value_type):
        self.code_maker.command_comment('pre_incr_expr ++%s' % value_type)
        if value_type == LIST:
            self.code_maker.command_dup()
            self.code_maker.command_ldc(0)
            self.code_maker.list.addFirst()
            return LIST
        else:
            raise error_processor.UnsupportedOperation(
                self.get_rule_position(),
                'Prefix increment operation for type "%s" is unsupported.' % (value_type)
            )
            
    def pre_decr_expr(self, value_type):
        self.code_maker.command_comment('pre_decr_expr --%s' % value_type)
        if value_type == LIST:
            self.code_maker.command_dup()
            self.code_maker.list.removeFirst()
            return LIST
        raise error_processor.UnsupportedOperation(
            self.get_rule_position(),
            'Prefix decrement operation for type "%s" is unsupported.' % (value_type)
        )
            
    def post_incr_expr(self, value_type):
        self.code_maker.command_comment('post_incr_expr %s++' % value_type)
        if value_type == LIST:
            self.code_maker.command_dup()
            self.code_maker.command_ldc(0)
            self.code_maker.list.addLast()
            return LIST
        raise error_processor.UnsupportedOperation(
            self.get_rule_position(),
            'Postfix increment operation for type "%s" is unsupported.' % (value_type)
        )
            
    def post_decr_expr(self, value_type):
        self.code_maker.command_comment('post_decr_expr %s--' % value_type)
        if value_type == LIST:
            self.code_maker.command_dup()
            self.code_maker.list.removeLast()
            return LIST
        raise error_processor.UnsupportedOperation(
            self.get_rule_position(),
            'Postfix decrement operation for type "%s" is unsupported.' % (value_type)
        )

    def not_expr(self, value_type):
        self.code_maker.command_comment('not_expr not %s' % value_type)
        if value_type == LIST:
            self.code_maker.list.to_int()

        false_label = self.code_maker.make_label(self.scope.scope_number, 'BOOL_FALSE')
        end_label = self.code_maker.make_label(self.scope.scope_number, 'BOOL_END')

        self.code_maker.command_invokestatic(TARGET_CLASS_NAME, 'neg', [INTEGER_JTYPE], INTEGER_JTYPE)

        return ELEMENT

    def call_expr(self, func_id, types):
        self.code_maker.command_comment('call_expr %s(%s)' % (func_id, ', '.join(types)))

        f_translated_params = [type_map[type] for type in types]

        # Check if calling function is builtin function
        if func_id in jcodemaker.BUILTIN_FUNCTIONS:
            builtin_retrutn_type, builtin_types = jcodemaker.BUILTIN_FUNCTIONS[func_id][0:2]
            if builtin_types == types:
                self.code_maker.command_invokestatic(
                    TARGET_CLASS_NAME, func_id, f_translated_params, type_map[builtin_retrutn_type]
                )
                return builtin_retrutn_type
            else:
                raise error_processor.BuiltinConflictException(
                    self.get_rule_position(), 'wrong args in calling builtin function %s.' % func_id
                )

        # Try to find function in one of scopes in stack from last to first
        func_description = None
        for scope in reversed(self.scopes_stack):
            if func_id in scope.funcs:
                func_description = scope.funcs[func_id]
                break

        if func_description and func_description[1] == types:
            func_type = func_description[0]
            if not func_type:
                func_type = ELEMENT
                self.__set_function_return_type(func_type)
            jmethod_id = scope.get_function_code_name(func_id)
            self.code_maker.command_invokestatic(
                TARGET_CLASS_NAME, jmethod_id, f_translated_params, type_map[func_type]
            )
            return func_type  # function return type
        else:
            raise error_processor.FunctionUnfoundException(
                self.get_rule_position(),
                "Can't found function with sugnature %s(%s)." % (func_id, ', '.join(types))
            )

    def cast_expr(self, value_type, target_type):
        self.code_maker.command_comment('cast_expr %s(%s)' % (target_type, value_type))

        if value_type == target_type:
            return target_type
        elif value_type == ELEMENT and target_type == LIST:
            # temporary store value to var 0
            self.code_maker.command_store(INTEGER_JTYPE, 0)

            # create list
            self.code_maker.list.new()

            # load value and call add method
            self.code_maker.command_dup()
            self.code_maker.command_load(INTEGER_JTYPE, 0)
            self.code_maker.list.addLast()
            return LIST
        elif value_type == LIST and target_type == ELEMENT:
            self.code_maker.list.to_int()
            return ELEMENT

    def slice_expr(self, list_type, value_type1, value_type2):
        if list_type == LIST:
            self.code_maker.command_comment('slice_expr [%s:%s]' % (value_type1, value_type2))
            if value_type1 == ELEMENT and not value_type2:
                self.code_maker.list.get()
                return ELEMENT
            elif value_type1 == ELEMENT and value_type2 == ELEMENT:
                self.code_maker.list.slice()
                return LIST

        raise error_processor.UnsupportedOperation(
            self.get_rule_position(),
            'Slice expression %s[%s:%s] is unsupported.' % ( list_type, value_type1, value_type2)
        )


    def list_maker_begin(self):
        """ Calls first for list_maker rule, before args """
        self.code_maker.command_comment('list_maker_begin')

        self.code_maker.list.new()
        self.code_maker.command_dup()  # additional copy for args

    def list_maker_arg(self, arg_type):
        """ Calls for every arg """
        self.code_maker.command_comment('list_maker_arg')

        if arg_type != ELEMENT:
            raise error_processor.UnsupportedOperation(
                self.get_rule_position(),
                'Making list of lists is unsupported.'
            )

        self.code_maker.list.addLast()
        self.code_maker.command_dup()

    def list_maker(self):
        """ Calls last for list_maker rule, return type """
        self.code_maker.command_comment('list_maker')

        self.code_maker.command_pop()
        return LIST

    def element_literal(self, value):
        self.code_maker.command_ldc(value)
        return ELEMENT

    def var_identifier(self, id):

        is_global_scope = self.scope.is_global()

        if not self.scope.contains_var(id):
            raise error_processor.UndefinedIDException(
                self.get_rule_position(),
                'variable "%s" not defined.' % (id)
            )

        if self.scope.is_global() or id in self.scope.global_vars:

            field_name = self.code_maker.make_field_name(id)
            value_type = self.scope.global_scope.var_types[id]
            field_jtype = type_map[value_type]
            self.code_maker.command_getstatic(TARGET_CLASS_NAME, field_name, field_jtype)
        else:
            var_number = self.get_var_number(id)
            value_type = self.scope.var_types[id]
            self.code_maker.command_load(type_map[value_type], var_number)
        return value_type

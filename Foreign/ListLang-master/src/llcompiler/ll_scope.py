#!/usr/bin/env python
# -*- coding: utf-8 -*-

__author__ = 'Oleg Beloglazov'

import jcodemaker

class Scope:

    total_scopes_number = 0

    def __init__(self, scope_name='main', global_scope=None):
        """ global_scope - scope that global for this scope, None if this scope is global """

        self.scope_number = self.total_scopes_number
        Scope.total_scopes_number += 1

        self.scope_name = scope_name

        self.vars = []
        self.var_types = {}      # dict {var_id: var_type}
        self.funcs = {}     # {function_id: (function_type, function_params_types, function_scope, ...)}
        self.code_maker = jcodemaker.JCodeMaker()
        if global_scope:
            self.global_scope = global_scope
            self.global_vars = []
        else:
            self.global_scope = self
            self.global_vars = None

    def is_global(self):
        return self.global_scope is self

    def add_function(self, f_params, f_scope):
        f_id = f_scope.scope_name
        f_params_types = [param[1] for param in f_params]
        self.funcs[f_id] = (None, f_params_types, f_scope)

    def add_var(self, var_id, var_type):
        self.vars.append(var_id)
        self.var_types[var_id] = var_type

    def add_global_var(self, var_id):
        self.global_vars.append(var_id)

    def get_function_code_name(self, name):
        return 's%i_%s' % (self.scope_number, name)

    def set_function_return_type(self, functoin_id, return_type):
        function_params_types, function_scope = self.funcs[functoin_id][1:3]
        self.funcs[functoin_id] = (return_type, function_params_types, function_scope)

    def contains_var(self, var_id):
        return var_id in self.vars or (not self.is_global() and var_id in self.global_vars)
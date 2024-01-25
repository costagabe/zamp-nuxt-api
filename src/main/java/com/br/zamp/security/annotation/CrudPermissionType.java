package com.br.zamp.security.annotation;

import com.br.zamp.enums.Permission;

public @interface CrudPermissionType {
   CrudMethod method();
   Permission[] permission();
   int level() default 0;
}

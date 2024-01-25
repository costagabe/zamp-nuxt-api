package com.br.zamp.security.annotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface CrudPermission {
  CrudPermissionType[] value();
}

package com.br.zamp.util;

import com.br.zamp.domain.enums.*;
import com.br.zamp.enums.Permission;
import com.br.zamp.enums.PermissionType;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ObjectUtil {

  private static final Set<Class<?>> SIMPLE_TYPES = new HashSet<>(Arrays.asList(
    String.class, Integer.class, Byte.class, Short.class, Long.class, Float.class, Double.class, Boolean.class,
    Character.class, AccountType.class, DocumentType.class, EntryType.class, PaymentType.class, Profile.class,
    RouteType.class, UserSituation.class, UserType.class, Permission.class, PermissionType.class
  ));


  public static boolean isEqual(Object obj1, Object obj2) {
    if (obj1 == null || obj2 == null) return obj1 == obj2;
    if (obj1.getClass() != obj2.getClass()) return false;

    for (Field field : obj1.getClass().getDeclaredFields()) {
      field.setAccessible(true); // Permite acesso a campos privados

      try {
        Object value1 = field.get(obj1);
        Object value2 = field.get(obj2);

        // Verifica se o tipo do campo é um dos tipos simples definidos
        if (SIMPLE_TYPES.contains(field.getType())) {
          if (value1 == null && value2 != null || value1 != null && !value1.equals(value2)) {
            return false;
          }
        }
      } catch (IllegalAccessException e) {
        throw new RuntimeException(e);
      }
    }

    return true;
  }

}

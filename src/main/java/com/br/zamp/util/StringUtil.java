package com.br.zamp.util;

public class StringUtil {
  public static String toCamelCase(String input) {
    if (input == null || input.isEmpty()) {
      return input;
    }
    return Character.toLowerCase(input.charAt(0)) + input.substring(1);
  }
}
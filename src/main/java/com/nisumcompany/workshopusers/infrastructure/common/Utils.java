package com.nisumcompany.workshopusers.infrastructure.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Utils {

  public static boolean validateRegex(String word, String pattern) {
    String name = word.trim();
    Pattern regex = Pattern.compile(pattern, Pattern.UNICODE_CHARACTER_CLASS);
    Matcher match = regex.matcher(name);
    if (match.matches()) {
      return true;
    }
    return false;
  }

}

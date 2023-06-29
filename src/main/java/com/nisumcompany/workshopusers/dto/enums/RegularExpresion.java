package com.nisumcompany.workshopusers.dto.enums;

import org.springframework.beans.factory.annotation.Value;

/**
 * Enumerado para expresiones regulares.
 */
public enum RegularExpresion {

  REGEX_EMAIL(
      "^(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$"), REGEX_PASSWORD(
      "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&])([A-Za-z\\d$@$!%*?&]|[^ ]){8,15}$"
  );

  private String expression;

  RegularExpresion(String expression) {
    this.expression = expression;
  }

  public String getExpression() {
    return expression;
  }
}

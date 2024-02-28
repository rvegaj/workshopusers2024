package com.nisumcompany.workshopusers.infraestructure.common;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.nisumcompany.workshopusers.infrastructure.common.Utils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UtilsTest {
  private String emailOk;

  private String emailWrong;

  private String patternEmail;
  @BeforeEach
  void init () {
    emailOk = "email@email.com";
    emailWrong = "email@email.";
    patternEmail = "^(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
  }
  @Test
  void validateRegexOk () {
    assertTrue(Utils.validateRegex(emailOk, patternEmail));
  }

  @Test
  void validateRegexWrong () {
    assertFalse(Utils.validateRegex(emailWrong, patternEmail));
  }

}

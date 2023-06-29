package com.nisumcompany.workshopusers.common.validator;

import com.nisumcompany.workshopusers.common.Constants;
import com.nisumcompany.workshopusers.common.Utils;
import com.nisumcompany.workshopusers.dto.enums.RegularExpresion;
import com.nisumcompany.workshopusers.infraestructure.web.exceptions.ExceptionRequestInvalid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class ValidationsRegexp {
  public  static void validateEmail(String email) throws ExceptionRequestInvalid {

      log.info("validateEmail: " + email);
      if (!Utils.validateRegex(email, RegularExpresion.REGEX_EMAIL.getExpression())) {
        log.error("Correo Electrónico no válido - validateEmail: " + email);
        throw new ExceptionRequestInvalid(Constants.MESSAGE_ERROR_EMAIL_INVALID);
      }
  }

  public static void validatePassword(String password) throws ExceptionRequestInvalid {
      if (!Utils.validateRegex(password, RegularExpresion.REGEX_PASSWORD.getExpression())) {
        log.error("Contraseña no válida - validatePassword: " + password);
        throw new ExceptionRequestInvalid(Constants.MESSAGE_ERROR_PASSWORD_BAD);
      }
  }
}

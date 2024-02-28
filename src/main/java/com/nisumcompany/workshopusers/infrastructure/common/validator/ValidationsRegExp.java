package com.nisumcompany.workshopusers.infrastructure.common.validator;

import com.nisumcompany.workshopusers.infrastructure.api.dto.UserDto;
import com.nisumcompany.workshopusers.infrastructure.api.web.exception.ExceptionRequestInvalid;
import com.nisumcompany.workshopusers.infrastructure.common.Constants;
import com.nisumcompany.workshopusers.infrastructure.common.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ValidationsRegExp {

  @Value("${spring.regular-expression.email}")
  private  String regularExpEmail;

  @Value("${spring.regular-expression.password}")
  private  String regularExpPassword;
  public  void validateEmailAndPassword(UserDto userDto) throws ExceptionRequestInvalid {

      log.info("validateEmail: " + userDto.getEmail());
      if (!Utils.validateRegex(userDto.getEmail(), regularExpEmail)) {
        log.error("Correo Electrónico no válido - validateEmail: " + userDto.getEmail());
        throw new ExceptionRequestInvalid(Constants.MESSAGE_ERROR_EMAIL_INVALID);
      }
    if (!Utils.validateRegex(userDto.getPassword(), regularExpPassword)) {
      log.error("Contraseña no válida - validatePassword: " + userDto.getPassword());
      throw new ExceptionRequestInvalid(Constants.MESSAGE_ERROR_PASSWORD_BAD);
    }
  }

}

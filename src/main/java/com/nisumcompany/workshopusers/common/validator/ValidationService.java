package com.nisumcompany.workshopusers.common.validator;

import com.nisumcompany.workshopusers.common.Constants;
import com.nisumcompany.workshopusers.dto.UserDto;
import com.nisumcompany.workshopusers.web.exceptions.ExceptionRequestInvalid;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ValidationService {
  Validator validator;

  @PostConstruct
  public void init(){
    var factory = Validation.buildDefaultValidatorFactory();
    validator = factory.getValidator();
  }
  public void validationRequest (UserDto userDto){
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();
    Set<ConstraintViolation<UserDto>> errores = validator.validate(userDto);

    for (ConstraintViolation<UserDto> error : errores) {
      log.info(error.getMessage());
      throw new ExceptionRequestInvalid(Constants.MESSAGE_ERROR_REQUEST_INVALID);
    }
  }

}

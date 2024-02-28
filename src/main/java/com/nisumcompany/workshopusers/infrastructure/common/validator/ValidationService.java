package com.nisumcompany.workshopusers.infrastructure.common.validator;

import com.nisumcompany.workshopusers.infrastructure.common.Constants;
import com.nisumcompany.workshopusers.infrastructure.api.dto.UserDto;
import com.nisumcompany.workshopusers.infrastructure.api.web.exception.ExceptionRequestInvalid;
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
    Set<ConstraintViolation<UserDto>> errors = validator.validate(userDto);

    for (ConstraintViolation<UserDto> error : errors) {
      log.info(error.getMessage());
      throw new ExceptionRequestInvalid(Constants.MESSAGE_ERROR_REQUEST_INVALID);
    }
  }

}

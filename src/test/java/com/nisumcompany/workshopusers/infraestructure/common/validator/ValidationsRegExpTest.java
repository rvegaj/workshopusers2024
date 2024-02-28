package com.nisumcompany.workshopusers.infraestructure.common.validator;

import static org.junit.jupiter.api.Assertions.assertThrows;

import com.nisumcompany.workshopusers.infrastructure.api.dto.UserDto;
import com.nisumcompany.workshopusers.infrastructure.api.web.exception.ExceptionRequestInvalid;
import com.nisumcompany.workshopusers.infrastructure.common.validator.ValidationsRegExp;
import com.nisumcompany.workshopusers.mock.UserDtoMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ValidationsRegExpTest {

  @Autowired
  private  ValidationsRegExp validationsRegexp;
  private UserDtoMock userDtoMock = new UserDtoMock();
  private UserDto  userDto = new UserDto();


  @BeforeEach
  void init(){
    userDto = userDtoMock.generate();

  }
  @Test
  void validateEmailAndPasswordEmailWrong () {
    userDto.setEmail("email@dominio");
    assertThrows(ExceptionRequestInvalid.class, ()->{
      validationsRegexp.validateEmailAndPassword(userDto);
    });

  }

  @Test
  void validateEmailAndPasswordPasswordWrong () {
    userDto.setPassword("Con12");
    assertThrows(ExceptionRequestInvalid.class, ()->{
      validationsRegexp.validateEmailAndPassword(userDto);
    });

  }

}

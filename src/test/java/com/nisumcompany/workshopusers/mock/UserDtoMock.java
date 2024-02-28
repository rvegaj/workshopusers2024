package com.nisumcompany.workshopusers.mock;

import com.nisumcompany.workshopusers.infrastructure.api.dto.PhoneDto;
import com.nisumcompany.workshopusers.infrastructure.api.dto.UserDto;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserDtoMock {

  PhoneDto phoneDto;

  UserDto userDto;


  public UserDto generate() {

    List<PhoneDto> phoneDtoList = new ArrayList();
    phoneDto = PhoneDto.builder()
        .countryCode("1")
        .cityCode("5")
        .number("6052345634")
        .id(Long.parseLong("1")).
        build();
     userDto = UserDto.builder().id("aa9f8258-f4a2-4d73-a334-851ac3f299aa")
        .name("Test test")
        .createDate(LocalDate.now())
        .email("email@dominio.co")
        .isActive(Boolean.TRUE)
        .lastLogin(LocalDate.now())
        .modified(LocalDate.now())
        .token("eyJhbGciOiJIUzI1NiJ9")
        .phones(phoneDtoList)
         .password("Contrasenia123*")
        .build();
        phoneDtoList.add(phoneDto);

        return userDto;
  }

}

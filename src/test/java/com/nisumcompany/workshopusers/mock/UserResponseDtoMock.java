package com.nisumcompany.workshopusers.mock;

import com.nisumcompany.workshopusers.infrastructure.api.dto.UserResponseDto;
import java.time.LocalDate;

public class UserResponseDtoMock {
  private UserResponseDto userResponseDto;

  public UserResponseDto generate() {
    userResponseDto = new UserResponseDto();
    return userResponseDto = UserResponseDto.builder().id("aa9f8258-f4a2-4d73-a334-851ac3f299aa")
        .createDate(LocalDate.now())
        .email("email@dominio.co")
        .isActive(Boolean.TRUE)
        .lastLogin(LocalDate.now())
        .modified(LocalDate.now())
        .token("eyJhbGciOiJIUzI1NiJ9")
        .build();
  }

}

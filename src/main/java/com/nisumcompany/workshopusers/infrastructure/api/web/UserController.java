package com.nisumcompany.workshopusers.infrastructure.api.web;

import com.nisumcompany.workshopusers.application.usecase.UserServiceImpl;
import com.nisumcompany.workshopusers.infrastructure.api.dto.UserDto;
import com.nisumcompany.workshopusers.infrastructure.api.dto.UserResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
  private final UserServiceImpl userServiceImpl;

  @PostMapping("/")
  @Operation(summary = "Creation of users")
  public ResponseEntity<UserResponseDto> createUser (@RequestBody UserDto userDto){
    return new ResponseEntity<>(userServiceImpl.createUser(userDto), HttpStatus.CREATED);
  }

}

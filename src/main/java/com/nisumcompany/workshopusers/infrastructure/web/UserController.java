package com.nisumcompany.workshopusers.infrastructure.web;

import com.nisumcompany.workshopusers.dto.UserDto;
import com.nisumcompany.workshopusers.dto.UserResponseDto;
import com.nisumcompany.workshopusers.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }
  @PostMapping("/")
  @Operation(summary = "Creation of users")
  public ResponseEntity<UserResponseDto> createUser (@RequestBody UserDto userDto){
    return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED);
  }

}

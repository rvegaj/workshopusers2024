package com.nisumcompany.workshopusers.web;

import com.nisumcompany.workshopusers.dto.UserDto;
import com.nisumcompany.workshopusers.service.UserService;
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
  public ResponseEntity<UserDto> createUser (@RequestBody UserDto userDto){
    return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED);
  }

}

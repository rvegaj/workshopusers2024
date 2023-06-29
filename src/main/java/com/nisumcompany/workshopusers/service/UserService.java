package com.nisumcompany.workshopusers.service;


import com.nisumcompany.workshopusers.dto.UserDto;
import com.nisumcompany.workshopusers.model.User;

public interface UserService {
 User findById(String email);
 UserDto createUser (UserDto user);
}

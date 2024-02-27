package com.nisumcompany.workshopusers.service;

import com.nisumcompany.workshopusers.common.Constants;
import com.nisumcompany.workshopusers.common.assemblers.UserResponseAssembler;
import com.nisumcompany.workshopusers.common.validator.ValidationService;
import com.nisumcompany.workshopusers.common.validator.ValidationsRegexp;
import com.nisumcompany.workshopusers.configuration.JwtUtils;
import com.nisumcompany.workshopusers.dto.UserDto;
import com.nisumcompany.workshopusers.dto.UserResponseDto;
import com.nisumcompany.workshopusers.infrastructure.exceptions.ExceptionUserExists;
import com.nisumcompany.workshopusers.infrastructure.persistence.UserRepository;
import com.nisumcompany.workshopusers.model.User;
import com.nisumcompany.workshopusers.model.mapper.UserMapper;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;
  private final UserMapper userMapper;
  private final ValidationService validationService;

  private final ValidationsRegexp validationsRegexp;
  private final JwtUtils jwtUtils;

  public UserServiceImpl(UserRepository userRepository, UserMapper userMapper,
      ValidationService validationService, ValidationsRegexp validationsRegexp, JwtUtils jwtUtils) {
    this.userRepository = userRepository;
    this.userMapper = userMapper;
    this.validationService = validationService;
    this.validationsRegexp = validationsRegexp;
    this.jwtUtils = jwtUtils;
  }

  @Override
  public User findById(String email) {
    return userRepository.findByEmail(email);
  }
  @Override
  public UserResponseDto createUser(UserDto userDto) {
        validationService.validationRequest(userDto);
        validationsRegexp.validateEmailAndPassword(userDto);
        User userResponse = findById(userDto.getEmail());
        if(Objects.isNull(userResponse)) {
          userDto.setModified(LocalDate.now());
          userDto.setLastLogin(LocalDate.now());
          userDto.setCreateDate(LocalDate.now());
          userDto.setIsActive(Boolean.TRUE);
          UUID uuid = UUID.randomUUID();
          userDto.setId(uuid.toString());
          userDto.setToken(jwtUtils.createToken(userDto.getEmail()));
          return UserResponseAssembler.convertToDto(
              userRepository.save(userMapper.userDtoToUserModel(userDto)));
        }
        else
          throw new ExceptionUserExists(Constants.MESSAGE_ERROR_EMAIL_REGISTRED);
  }

}

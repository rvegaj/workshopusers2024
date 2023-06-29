package com.nisumcompany.workshopusers.service;
import com.nisumcompany.workshopusers.common.Constants;
import com.nisumcompany.workshopusers.common.validator.ValidationService;
import com.nisumcompany.workshopusers.common.validator.ValidationsRegexp;
import com.nisumcompany.workshopusers.dao.UserRepository;
import com.nisumcompany.workshopusers.dto.UserDto;
import com.nisumcompany.workshopusers.infraestructure.web.exceptions.ExceptionUserExists;
import com.nisumcompany.workshopusers.mapper.UserMapper;
import com.nisumcompany.workshopusers.model.User;
import java.time.LocalDate;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;
  private final UserMapper userMapper;

  private final ValidationService validationService;

  public UserServiceImpl(UserRepository userRepository, UserMapper userMapper,
      ValidationService validationService) {
    this.userRepository = userRepository;
    this.userMapper = userMapper;
    this.validationService = validationService;
  }

  @Override
  public User findById(String email) {
    return userRepository.findByEmail(email);
  }
  @Override
  public UserDto createUser(UserDto userDto) {
        validationService.validationRequest(userDto);
        ValidationsRegexp.validateEmail(userDto.getEmail());
        ValidationsRegexp.validatePassword(userDto.getPassword());
        User userResponse = findById(userDto.getEmail());
        if(userResponse == null) {
          userDto.setModified(LocalDate.now());
          userDto.setLastLogin(LocalDate.now());
          userDto.setCreateDate(LocalDate.now());
          userDto.setIsActive(Boolean.TRUE);
          UUID uuid = UUID.randomUUID();
          userDto.setToken(uuid.toString());
          return userMapper.userModelToUserDto(
              userRepository.save(userMapper.userDtoToUserModel(userDto)));
        }
        else
          throw new ExceptionUserExists(Constants.MESSAGE_ERROR_EMAIL_REGISTRED);
  }

}

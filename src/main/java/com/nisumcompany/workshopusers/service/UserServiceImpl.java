package com.nisumcompany.workshopusers.service;
import com.nisumcompany.workshopusers.common.Constants;
import com.nisumcompany.workshopusers.common.Utils;
import com.nisumcompany.workshopusers.dao.UserRepository;
import com.nisumcompany.workshopusers.dto.UserDto;
import com.nisumcompany.workshopusers.dto.enums.RegularExpresion;
import com.nisumcompany.workshopusers.infraestructure.web.exceptions.ExceptionRequestInvalid;
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

  public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
    this.userRepository = userRepository;
    this.userMapper = userMapper;
  }

  @Override
  public User findById(String email) {
    return userRepository.findByEmail(email);
  }
  @Override
  public UserDto createUser(UserDto userDto) {
        validateEmail(userDto.getEmail());
        validatePassword(userDto.getPassword());
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
  public void validateEmail(String email) throws ExceptionRequestInvalid {
    if (email != null) {
      log.info("validateEmail: " + email);
      if (!"".equals(email)
          && !Utils.validateRegex(email, RegularExpresion.REGEX_EMAIL.getExpression())) {
        log.error("Correo Electrónico no válido - validateEmail: " + email);
        throw new ExceptionRequestInvalid(Constants.MESSAGE_ERROR_EMAIL_INVALID);
      }
    } else
      throw new ExceptionRequestInvalid(Constants.MESSAGE_ERROR_EMAIL_EMPTY);
  }

  public void validatePassword(String password) throws ExceptionRequestInvalid {
    if (password != null) {
      if (!"".equals(password)
          && !Utils.validateRegex(password, RegularExpresion.REGEX_PASSWORD.getExpression())) {
        log.error("Contraseña no válida - validatePassword: " + password);
        throw new ExceptionRequestInvalid(Constants.MESSAGE_ERROR_PASSWORD_BAD);
      }
    } else
      throw new ExceptionRequestInvalid(Constants.MESSAGE_ERROR_EMAIL_EMPTY);
  }

}

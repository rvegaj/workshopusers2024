package com.nisumcompany.workshopusers.application.usecase;

import com.nisumcompany.workshopusers.domain.model.User;
import com.nisumcompany.workshopusers.domain.repository.UserRepository;
import com.nisumcompany.workshopusers.infrastructure.api.dto.UserDto;
import com.nisumcompany.workshopusers.infrastructure.api.dto.UserResponseDto;
import com.nisumcompany.workshopusers.infrastructure.api.web.exception.ExceptionUserExists;
import com.nisumcompany.workshopusers.infrastructure.common.Constants;
import com.nisumcompany.workshopusers.infrastructure.common.assemblers.UserResponseAssembler;
import com.nisumcompany.workshopusers.infrastructure.common.validator.ValidationService;
import com.nisumcompany.workshopusers.infrastructure.common.validator.ValidationsRegExp;
import com.nisumcompany.workshopusers.infrastructure.configuration.JwtUtils;
import com.nisumcompany.workshopusers.infrastructure.mapper.UserMapper;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl {
  private final UserRepository userRepository;
  private final UserMapper userMapper;
  private final ValidationService validationService;

  private final ValidationsRegExp validationsRegexp;
  private final JwtUtils jwtUtils;

  public User findByEmail(String email) {
    return userRepository.findByEmail(email);
  }

  public UserResponseDto createUser(UserDto userDto) {
        validationService.validationRequest(userDto);
        validationsRegexp.validateEmailAndPassword(userDto);
        User userResponse = findByEmail(userDto.getEmail());
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

package com.nisumcompany.workshopusers.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import com.nisumcompany.workshopusers.common.validator.ValidationService;
import com.nisumcompany.workshopusers.common.validator.ValidationsRegexp;
import com.nisumcompany.workshopusers.configuration.JwtUtils;
import com.nisumcompany.workshopusers.dto.UserResponseDto;
import com.nisumcompany.workshopusers.infrastructure.persistence.UserRepository;
import com.nisumcompany.workshopusers.infrastructure.web.exceptions.ExceptionUserExists;
import com.nisumcompany.workshopusers.mock.UserDtoMock;
import com.nisumcompany.workshopusers.mock.UserMock;
import com.nisumcompany.workshopusers.model.User;
import com.nisumcompany.workshopusers.model.mapper.UserMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@TestPropertySource("classpath:application-test.yml")
@SpringBootTest
class UserServiceImplTest {
  @Spy
  @InjectMocks
  private UserServiceImpl userServiceImpl;
  @Mock
  private ValidationService validationService;

  @Mock
  private ValidationsRegexp validationsRegexp;

  @Mock
  private UserMapper userMapper;
  @Mock
  private UserRepository userRepository;
  @Mock
  private JwtUtils jwtUtils;

  private UserMock userMock = new UserMock();
  private UserDtoMock userDtoMock = new UserDtoMock();

  private User user = new User();

  @BeforeEach
  public void init() {
    new UserServiceImpl(userRepository, userMapper,
        validationService, validationsRegexp, jwtUtils);
    user= userMock.generate();

  }

  @Test
  public void findByIdOk() {
    when(userRepository.findByEmail(Mockito.anyString())).thenReturn(userMock.generate());
    User userResponse = userServiceImpl.findByEmail("email@email.com");
    assertNotNull(userResponse);

  }

  @Test
  public void createUserOk() {
    when(userRepository.findByEmail(Mockito.anyString())).thenReturn(null);
    UserResponseDto userResponseDto = userServiceImpl.createUser(userDtoMock.generate());
    assertNotNull(userResponseDto);
  }

  @Test
  public void createUserUserExists() {
    when(userRepository.findByEmail(Mockito.anyString())).thenReturn(userMock.generate());
    assertThrows(ExceptionUserExists.class, ()->{
      userServiceImpl.createUser(userDtoMock.generate());
    });
  }
}

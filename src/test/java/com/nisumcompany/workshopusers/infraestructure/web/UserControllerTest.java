package com.nisumcompany.workshopusers.infraestructure.web;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nisumcompany.workshopusers.WorkshopUsersApplication;
import com.nisumcompany.workshopusers.common.Constants;
import com.nisumcompany.workshopusers.common.validator.ValidationService;
import com.nisumcompany.workshopusers.infrastructure.exceptions.ExceptionRequestInvalid;
import com.nisumcompany.workshopusers.infrastructure.exceptions.ExceptionUserExists;
import com.nisumcompany.workshopusers.infrastructure.persistence.UserRepository;
import com.nisumcompany.workshopusers.infrastructure.web.UserController;
import com.nisumcompany.workshopusers.mocks.UserDtoMock;
import com.nisumcompany.workshopusers.mocks.UserMock;
import com.nisumcompany.workshopusers.mocks.UserResponseDtoMock;
import com.nisumcompany.workshopusers.model.mapper.UserMapper;
import com.nisumcompany.workshopusers.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = WorkshopUsersApplication.class)
@WebMvcTest({UserController.class})
class UserControllerTest {

  @Autowired
  private MockMvc mockMvc;
  @MockBean
  private UserService userService;

  @MockBean
  private UserMapper userMapper;
  @MockBean
  private ValidationService validationService;
  @MockBean
  private UserRepository userRepository;
  private String endpointCreateUser;
  @Autowired
  ObjectMapper mapper;
  private UserDtoMock userDtoMock = new UserDtoMock();
  private UserResponseDtoMock userResponseDtoMock = new UserResponseDtoMock();
  private UserMock userMock = new UserMock();

  @BeforeEach
  void setUp() {
    endpointCreateUser = "/api/v1/user/";

  }
  @Test
  public void createUserSuccessfulNew() throws Exception {

    String  json = mapper.writeValueAsString(userDtoMock.generate());
    when(userService.createUser(userDtoMock.generate())).thenReturn(userResponseDtoMock.generate());
    when(userRepository.save(userMapper.userDtoToUserModel(userDtoMock.generate()))).thenReturn(null);
     this.mockMvc.perform(
            post(endpointCreateUser).accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(json))
        .andExpect(status().isCreated())
         .andExpect(content().string(containsString(
             mapper.writeValueAsString(userResponseDtoMock.generate()).replaceAll("\\\\", ""))))
        .andReturn();
  }

  @Test
  public void createUserExistsSuccessful() throws Exception {

    String  json = mapper.writeValueAsString(userDtoMock.generate());
    when(userService.findById(Mockito.anyString())).thenReturn(userMock.generate());
    when(userRepository.findByEmail(Mockito.anyString())).thenReturn(userMock.generate());
    when(userService.createUser(userDtoMock.generate())).thenThrow(new ExceptionUserExists(Constants.MESSAGE_ERROR_EMAIL_REGISTRED));
    this.mockMvc.perform(
            post(endpointCreateUser).accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(json))
        .andExpect(status().isConflict())
        .andExpect(content().string(containsString(Constants.MESSAGE_ERROR_EMAIL_REGISTRED)))
        .andReturn();
  }

  @Test
  public void createUserBadEmail() throws Exception {

    userDtoMock.generate().setEmail("emailbad@email");
    String  json = mapper.writeValueAsString(userDtoMock.generate());
    when(userService.createUser(userDtoMock.generate())).thenThrow(new ExceptionRequestInvalid(Constants.MESSAGE_ERROR_EMAIL_INVALID));
    when(userRepository.findByEmail(Mockito.anyString())).thenReturn(userMock.generate());

    this.mockMvc.perform(
            post(endpointCreateUser).accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(json))
        .andExpect(status().isBadRequest())
        .andExpect(content().string(containsString(Constants.MESSAGE_ERROR_EMAIL_INVALID)))
        .andReturn();
  }

  @Test
  public void createUserBadPassword() throws Exception {

    userDtoMock.generate().setPassword("11111L");
    String  json = mapper.writeValueAsString(userDtoMock.generate());
    when(userService.createUser(userDtoMock.generate())).thenThrow(new ExceptionRequestInvalid(Constants.MESSAGE_ERROR_PASSWORD_BAD));
    when(userRepository.findByEmail(Mockito.anyString())).thenReturn(userMock.generate());
    this.mockMvc.perform(
            post(endpointCreateUser).accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(json))
        .andExpect(status().isBadRequest())
        .andExpect(content().string(containsString(Constants.MESSAGE_ERROR_PASSWORD_BAD)))
        .andReturn();
  }




}

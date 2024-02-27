package com.nisumcompany.workshopusers.web;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nisumcompany.workshopusers.WorkshopUsersApplication;
import com.nisumcompany.workshopusers.dao.UserRepository;
import com.nisumcompany.workshopusers.dto.PhoneDto;
import com.nisumcompany.workshopusers.dto.UserDto;
import com.nisumcompany.workshopusers.mapper.UserMapper;
import com.nisumcompany.workshopusers.service.UserService;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
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
import org.springframework.test.web.servlet.MvcResult;

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
  private UserRepository userRepository;

  private String endpointCreateUser;

  @Autowired
  ObjectMapper mapper;

  PhoneDto phoneDto;
  UserDto userDto;

  @BeforeEach
  void setUp(){
    endpointCreateUser = "/api/v1/user/";
  List<PhoneDto> phoneDtoList = new ArrayList();


     phoneDto = PhoneDto.builder()
            .countryCode("1")
            .cityCode("5")
            .number("6052345634")
            .id(Long.parseLong("1")).
              build();
     userDto = UserDto.builder().id("aa9f8258-f4a2-4d73-a334-851ac3f299aa")
        .name("Test test")
        .createDate(LocalDate.now())
        .email("email@dominio.co")
        .isActive(Boolean.TRUE)
        .lastLogin(LocalDate.now())
        .modified(LocalDate.now())
        .token("eyJhbGciOiJIUzI1NiJ9")
        .phones(phoneDtoList)
        .build();
    phoneDtoList.add(phoneDto);
  }
  @Test
  public void createUserSucessfull() throws Exception {
    when(userRepository.findByEmail(Mockito.anyString())).thenReturn(Mockito.any());
    when(userRepository.save(userMapper.userDtoToUserModel(userDto))).thenReturn(null);
    MvcResult result = getResultPost(endpointCreateUser);
    Assertions.assertNotNull(result);
  }

  private MvcResult getResultPost(String endpointCreateUser) throws Exception {
    String json = mapper.writeValueAsString(phoneDto);

    return this.mockMvc.perform(
            post(endpointCreateUser).accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(json))
        .andReturn();

  }

}

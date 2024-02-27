package com.nisumcompany.workshopusers.common.assemblers;

import com.nisumcompany.workshopusers.dto.UserResponseDto;
import com.nisumcompany.workshopusers.model.User;
import java.util.Objects;

public class UserResponseAssembler {

  public static UserResponseDto convertToDto (User user) {
    if (!Objects.isNull(user)){
      return UserResponseDto.builder()
          .createDate(user.getCreateDate())
          .email(user.getEmail())
          .id(user.getId())
          .modified(user.getModified())
          .isActive(user.getIsActive())
          .lastLogin(user.getLastLogin())
          .token(user.getToken())
          .build();
    }
    return UserResponseDto.builder().build();
  }

}
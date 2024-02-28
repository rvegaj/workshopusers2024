package com.nisumcompany.workshopusers.infrastructure.mapper;

import com.nisumcompany.workshopusers.infrastructure.api.dto.UserDto;
import com.nisumcompany.workshopusers.domain.model.User;
import lombok.Generated;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Generated
@Mapper
public interface UserMapper {

  UserDto userModelToUserDto(User user);

  @InheritInverseConfiguration
  User userDtoToUserModel(UserDto userDto);


}

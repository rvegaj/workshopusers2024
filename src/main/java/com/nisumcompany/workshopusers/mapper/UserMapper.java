package com.nisumcompany.workshopusers.mapper;

import com.nisumcompany.workshopusers.dto.UserDto;
import com.nisumcompany.workshopusers.model.User;
import lombok.Generated;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Generated
@Mapper
public interface UserMapper {

  UserDto  userModelToUserDto(User user);

  @InheritInverseConfiguration
  User userDtoToUserModel(UserDto userDto);


}

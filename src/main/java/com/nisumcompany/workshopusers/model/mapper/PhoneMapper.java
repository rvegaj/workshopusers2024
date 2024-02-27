package com.nisumcompany.workshopusers.model.mapper;

import com.nisumcompany.workshopusers.dto.PhoneDto;
import com.nisumcompany.workshopusers.model.Phone;
import lombok.Generated;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Generated
@Mapper
public interface PhoneMapper {
  PhoneMapper INSTANCE = Mappers.getMapper(PhoneMapper.class);

  PhoneDto phoneModelToPhoneDto(Phone phone);

  @InheritInverseConfiguration
  Phone phoneDtoToPhoneModel (PhoneDto phoneDto);

}

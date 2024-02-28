package com.nisumcompany.workshopusers.infrastructure.mapper;

import com.nisumcompany.workshopusers.domain.model.Phone;
import com.nisumcompany.workshopusers.infrastructure.api.dto.PhoneDto;
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

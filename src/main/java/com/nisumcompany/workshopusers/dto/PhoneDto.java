package com.nisumcompany.workshopusers.dto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class PhoneDto {
  private Long id;
  private String number;
  private String cityCode;
  private String countryCode;
  @JsonIgnore
  private UserDto user;

}

package com.nisumcompany.workshopusers.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class UserDto implements Serializable {

  private static final long serialVersionUID = 1L;
  @JsonProperty
  private Long id;
  @JsonProperty
  private String name;
  @JsonProperty
  private String email;
  @JsonProperty
  private String password;
  @JsonProperty
  private LocalDate createDate;
  @JsonProperty
  private LocalDate modified;
  @JsonProperty
  private Boolean isActive;
  @JsonProperty
  private String token;
  @JsonProperty
  private LocalDate lastLogin;

  @JsonProperty
  private List<PhoneDto> phones = new ArrayList<>();

}

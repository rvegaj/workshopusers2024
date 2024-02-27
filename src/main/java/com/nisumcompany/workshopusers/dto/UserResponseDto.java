package com.nisumcompany.workshopusers.dto;

import java.io.Serializable;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class UserResponseDto implements Serializable {

  private static final long serialVersionUID = 1L;

  private String id;
  private String email;

  private LocalDate createDate;

  private LocalDate modified;

  private Boolean isActive;

  private String token;

  private LocalDate lastLogin;

}

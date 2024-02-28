package com.nisumcompany.workshopusers.infrastructure.api.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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

  private String id;

  @NotBlank(message = "El nombre es requerido")
  @NotNull(message = "El nombre es requerido")
  private String name;

  @NotBlank(message = "El email es requerido")
  @NotNull(message = "El email es requerido")
  private String email;

  @NotBlank(message = "La constraseña es requerida")
  @NotNull(message = "La constraseña es requerida")
  private String password;

  private LocalDate createDate;

  private LocalDate modified;

  private Boolean isActive;

  private String token;

  private LocalDate lastLogin;


  @NotNull
  @NotEmpty
  @Valid
  private List<PhoneDto> phones = new ArrayList<>();

}

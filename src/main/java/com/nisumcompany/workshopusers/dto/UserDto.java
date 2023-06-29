package com.nisumcompany.workshopusers.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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
  @JsonProperty
  private Long id;
  @JsonProperty
  @NotBlank(message = "El nombre es requerido")
  @NotNull(message = "El nombre es requerido")
  private String name;
  @JsonProperty
  @NotBlank(message = "El email es requerido")
  @NotNull(message = "El email es requerido")
  private String email;
  @JsonProperty
  @NotBlank(message = "La constraseña es requerida")
  @NotNull(message = "La constraseña es requerida")
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
  @NotNull
  @NotEmpty
  @Valid
  private List<PhoneDto> phones = new ArrayList<>();

}

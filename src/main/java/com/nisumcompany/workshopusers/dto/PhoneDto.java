package com.nisumcompany.workshopusers.dto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class PhoneDto {

  private Long id;
  @NotEmpty(message = "El número de telefono es requerido")
  @NotNull(message = "El número de telefono es requerido")
  @NotBlank(message = "El número de telefono es requerido")
  private String number;
  @NotEmpty(message = "El código de la zona es requerido")
  @NotNull(message = "El código de la zona es requerido")
  @NotBlank(message = "El número de telefono es requerido")
  private String cityCode;
  @NotEmpty(message = "El código del país es requerido")
  @NotNull(message = "El código del país es requerido")
  @NotBlank(message = "El número de telefono es requerido")
  private String countryCode;
  @JsonIgnore
  private UserDto user;

}

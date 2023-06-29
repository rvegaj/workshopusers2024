package com.nisumcompany.workshopusers.dto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class PhoneDto {

  private Long id;
  @NotBlank(message = "El número de telefono es requerido")
  @NotNull(message = "El número de telefono es requerido")
  private String number;

  @NotBlank(message = "El código de la zona es requerido")
  @NotNull(message = "El código de la zona es requerido")
  private String cityCode;
  @NotBlank(message = "El código del país es requerido")
  @NotNull(message = "El código del país es requerido")
  private String countryCode;
  @JsonIgnore
  private UserDto user;

}

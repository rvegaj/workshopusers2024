package com.nisumcompany.workshopusers.dto;

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
public class UserResponse implements Serializable {

  private static final long serialVersionUID = 1L;

  private String id;

  private String name;

  private String email;

  private String password;

  private LocalDate createDate;

  private LocalDate modified;

  private Boolean isActive;

  private String token;

  private LocalDate lastLogin;

}

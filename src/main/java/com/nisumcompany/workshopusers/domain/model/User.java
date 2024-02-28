package com.nisumcompany.workshopusers.domain.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User implements Serializable {

  @Id
  private String id;
  @Column(name = "name")
  private String name;
  @Column(name = "email")
  private String email;

  @Column(name = "password")
  private String password;

  @Column(name = "created")
  private LocalDate createDate;

  @Column(name = "modified")
  private LocalDate modified;

  @Column(name = "isactive")
  private Boolean isActive;

  @Column(name = "token")
  private String token;

  @Column(name = "lastlogin")
  private LocalDate lastLogin;

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
  @JoinColumn(name = "user_id", nullable = false)
  @JsonManagedReference
  private List<Phone> phones;

}

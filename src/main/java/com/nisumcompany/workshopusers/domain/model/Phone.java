package com.nisumcompany.workshopusers.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.Generated;

@Entity
@Table(name = "phones")
@Data
public class Phone {
  @Id
  @GeneratedValue
  private long id;

  @Column(name = "number")
  private String number;

  @Column(name = "citycode")
  private String cityCode;

  @Column(name = "countrycode")
  private String countryCode;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="user_id", updatable = false, insertable = false, foreignKey = @ForeignKey(name = "FK_PHONE_USER_ID"), nullable = false)
  @JsonBackReference
  private User user;

}

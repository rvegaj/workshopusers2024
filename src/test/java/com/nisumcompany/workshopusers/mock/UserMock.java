package com.nisumcompany.workshopusers.mock;

import com.nisumcompany.workshopusers.domain.model.User;
import java.time.LocalDate;

public class UserMock {

  private User user;

  public User generate() {
    user = new User();
    user.setCreateDate(LocalDate.now());
    user.setId("12092323042mfdmmsd");
    user.setEmail("email@email.com");
    return user;

  }

}

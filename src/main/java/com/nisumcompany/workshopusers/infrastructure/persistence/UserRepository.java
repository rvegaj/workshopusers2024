package com.nisumcompany.workshopusers.infrastructure.persistence;


import com.nisumcompany.workshopusers.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

  User findByEmail(String email);
}

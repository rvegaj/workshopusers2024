package com.nisumcompany.workshopusers.domain.repository;


import com.nisumcompany.workshopusers.domain.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

  User findByEmail(String email);
}

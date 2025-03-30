
package com.examly.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examly.springapp.model.User;

public interface UserRepository extends JpaRepository<User,Long>{

           @Query("SELECT o FROM User o WHERE o.id = :id")
    Optional<User>findByEmail(String email);

      @Query("SELECT i FROM User i WHERE i.password = :password")
    List<User>findUserByPassword(@Param("password") String password);
}

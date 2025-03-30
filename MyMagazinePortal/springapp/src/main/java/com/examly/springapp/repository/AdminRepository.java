package com.examly.springapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.examly.springapp.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {
        @Query("SELECT o FROM Admin o WHERE o.id = :id")
    Optional<Admin>findByEmail(String email);

}

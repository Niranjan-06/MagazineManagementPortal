
package com.examly.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examly.springapp.model.Publisher;


@Repository
public interface PublisherRepository extends JpaRepository<Publisher,Integer>{

           @Query("SELECT o FROM Publisher o WHERE o.id = :id")
    Optional<Publisher>findByEmail(String email);

      @Query("SELECT i FROM Publisher i WHERE i.address = :address")
    List<Publisher>findPublisherByAddress(@Param("address") String address);

}

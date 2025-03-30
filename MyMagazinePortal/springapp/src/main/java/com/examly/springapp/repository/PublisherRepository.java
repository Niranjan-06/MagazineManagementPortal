package com.examly.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examly.springapp.model.Publisher;


@Repository
public interface PublisherRepository extends JpaRepository<Publisher,Integer>{

    

}

package com.examly.springapp.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.examly.springapp.model.Magazine;

@Repository
public interface MagazineRepository extends JpaRepository<Magazine,Integer> {
    
    @Modifying
    List<Magazine> findByGenre(String genre);
    List<Magazine> findByReleaseYear(Integer releaseYear);

    Page<Magazine>findAll(Pageable pageable);

  
    @Query("SELECT i FROM Magazine i WHERE i.genre = :genre")
    List<Magazine>findMagazineByGenre(@Param("genre") String genre);

    @Query("SELECT i FROM Magazine i WHERE i.releaseYear = :releaseYear")
    List<Magazine>findMagazineByReleaseYear(@Param("releaseYear") Integer releaseYear);

    
}

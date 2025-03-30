package com.examly.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Magazine;
import com.examly.springapp.model.Publisher;
import com.examly.springapp.repository.MagazineRepository;
import com.examly.springapp.repository.PublisherRepository;

import java.util.List;

@Service
public class MagazineService {

    @Autowired
    private MagazineRepository magazineRepository;

    @Autowired
    private PublisherRepository publisherRepository;

  
    public Magazine addMagazine(Magazine magazine, Integer publisherId) {
        Publisher publisher = publisherRepository.findById(publisherId)
                .orElseThrow(() -> new RuntimeException("Publisher not found with ID: " + publisherId));

        magazine.setPublisher(publisher); // Assigning Publisher to Magazine
        return magazineRepository.save(magazine);
    }

    public List<Magazine> getAllMagazines() {
        return magazineRepository.findAll();
    }

    public List<Magazine> getMagazinesByGenre(String genre) {
        return magazineRepository.findByGenre(genre);
    }

    public List<Magazine> getMagazinesByReleaseYear(Integer releaseYear) {
        return magazineRepository.findByReleaseYear(releaseYear);
    }

    public Magazine getMagazineById(Integer id) {
        return magazineRepository.findById(id).orElse(null);
    }

    public Magazine updateMagazine(Integer id, Magazine updatedMagazine, Integer publisherId) {
        Magazine existingMagazine = magazineRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Magazine not found with ID: " + id));

        Publisher publisher = publisherRepository.findById(publisherId)
                .orElseThrow(() -> new RuntimeException("Publisher not found with ID: " + publisherId));

        existingMagazine.setTitle(updatedMagazine.getTitle());
        existingMagazine.setGenre(updatedMagazine.getGenre());
        existingMagazine.setIssueNumber(updatedMagazine.getIssueNumber());
        existingMagazine.setReleaseYear(updatedMagazine.getReleaseYear());
        existingMagazine.setPrice(updatedMagazine.getPrice());
        existingMagazine.setPublisher(publisher); 

        return magazineRepository.save(existingMagazine);
    }

    public void deleteMagazine(Integer id) {
        if (!magazineRepository.existsById(id)) {
            throw new RuntimeException("Magazine not found with ID: " + id);
        }
        magazineRepository.deleteById(id);
    }

    public Page<Magazine> getAllMagazines(int page, int size, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return magazineRepository.findAll(pageable);
    }
}

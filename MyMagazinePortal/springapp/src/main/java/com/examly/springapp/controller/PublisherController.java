package com.examly.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.examly.springapp.model.Magazine;
import com.examly.springapp.model.Publisher;
import com.examly.springapp.service.PublisherService;

@RestController
@RequestMapping("/publishers")
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @PostMapping
    public Publisher addPublisher(@RequestBody Publisher publisher) {
        return publisherService.addPublisher(publisher);
    }

    @GetMapping
    public List<Publisher> getAllPublishers() {
        return publisherService.getAllPublishers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Publisher> getPublisherById(@PathVariable Integer id) {
        return ResponseEntity.ok(publisherService.getPublisherById(id));
    }


    @GetMapping("/{id}/magazines")
    public ResponseEntity<List<Magazine>> getMagazinesByPublisher(@PathVariable Integer id) {
        return ResponseEntity.ok(publisherService.getMagazinesByPublisher(id));
    }

    @DeleteMapping("/{id}")
    public String deletePublisher(@PathVariable Integer id) {
        boolean deleted = publisherService.deletePublisher(id);
        return deleted ? "Publisher deleted" : "Publisher not found.";
    }
}

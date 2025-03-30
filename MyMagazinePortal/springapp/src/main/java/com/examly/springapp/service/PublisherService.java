package com.examly.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.examly.springapp.model.Magazine;
import com.examly.springapp.model.Publisher;
import com.examly.springapp.repository.PublisherRepository;

@Service
public class PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    public Publisher addPublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    public Publisher getPublisherById(Integer id) {
        return publisherRepository.findById(id).orElse(null);
    }

    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }

  
    public List<Magazine> getMagazinesByPublisher(Integer publisherId) {
        Publisher publisher = publisherRepository.findById(publisherId)
                .orElseThrow(() -> new RuntimeException("Publisher not found with ID: " + publisherId));
        return publisher.getMagazines();
    }

    public boolean deletePublisher(Integer id) {
        if (publisherRepository.existsById(id)) {
            publisherRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

package com.examly.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.Magazine;
import com.examly.springapp.service.MagazineService;

import java.util.List;

@RestController
@RequestMapping("/magazines")
public class MagazineController {

    @Autowired
    private MagazineService magazineService;

    @PostMapping("/{publisherId}")
    public ResponseEntity<Magazine> addMagazine(@RequestBody Magazine magazine, @PathVariable Integer publisherId) {
        return ResponseEntity.ok(magazineService.addMagazine(magazine, publisherId));
    }

    @GetMapping
    public ResponseEntity<List<Magazine>> getAllMagazines() {
        return ResponseEntity.ok(magazineService.getAllMagazines());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Magazine> getMagazineById(@PathVariable Integer id) {
        return ResponseEntity.ok(magazineService.getMagazineById(id));
    }


    @PutMapping("/{id}/{publisherId}")
    public ResponseEntity<Magazine> updateMagazine(@PathVariable Integer id, @RequestBody Magazine updatedMagazine, @PathVariable Integer publisherId) {
        return ResponseEntity.ok(magazineService.updateMagazine(id, updatedMagazine, publisherId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMagazine(@PathVariable Integer id) {
        magazineService.deleteMagazine(id);
        return ResponseEntity.ok("Deleted Magazine ID: " + id);
    }
}

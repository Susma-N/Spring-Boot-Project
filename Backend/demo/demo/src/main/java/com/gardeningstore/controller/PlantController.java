// src/main/java/com/gardeningstore/controller/PlantController.java

package com.gardeningstore.controller;

import com.gardeningstore.entity.Plant;
import com.gardeningstore.service.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plants")
public class PlantController {

    @Autowired
    private PlantService plantService;

    @GetMapping
    public List<Plant> findAll() {
        return plantService.findAll();
    }

    @PostMapping
    public ResponseEntity<Plant> create(@RequestBody Plant plant) {
        Plant createdPlant = plantService.create(plant);
        return new ResponseEntity<>(createdPlant, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plant> findById(@PathVariable Long id) {
        Plant plant = plantService.findById(id);
        if (plant == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(plant, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Plant> update(@PathVariable Long id, @RequestBody Plant plant) {
        Plant existingPlant = PlantService.findById(id);
        if (existingPlant == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        plant.setId(id);
        Plant updatedPlant = plantService.update(plant);
        return new ResponseEntity<>(updatedPlant, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Plant plant = plantService.findById(id);
        if (plant == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        plantService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
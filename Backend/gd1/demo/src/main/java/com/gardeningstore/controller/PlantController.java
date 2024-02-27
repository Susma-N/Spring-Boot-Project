package com.gardeningstore.controller;

import com.gardeningstore.entity.Plant;
import com.gardeningstore.service.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/plants")
public class PlantController {

    @Autowired
    private PlantService plantService;

    @GetMapping
    public List<Plant> getAllPlants() {
        return plantService.getAllPlants();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plant> getPlantById(@PathVariable int id) {
        Optional<Plant> plant = plantService.getPlantById(id);
        return plant.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Plant> addPlant(@RequestBody Plant plant) {
        Plant savedPlant = plantService.addPlant(plant);
        return new ResponseEntity<>(savedPlant, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Plant> updatePlant(@PathVariable int id, @RequestBody Plant updatedPlant) {
        Plant plant = plantService.updatePlant(id, updatedPlant);
        if (plant != null) {
            return new ResponseEntity<>(plant, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlant(@PathVariable int id) {
        plantService.deletePlant(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

package com.gardeningstore.service;

import com.gardeningstore.entity.Plant;
import com.gardeningstore.repository.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlantService {

    @Autowired
    private PlantRepository plantRepository;

    public List<Plant> findAll() {
        return plantRepository.findAll();
    }

    public Optional<Plant> findById(Long id) {
        return plantRepository.findById(id);
    }

    public Plant save(Plant plant) {
        return plantRepository.save(plant);
    }

    public void deleteById(Long id) {
        plantRepository.deleteById(id);
    }
}
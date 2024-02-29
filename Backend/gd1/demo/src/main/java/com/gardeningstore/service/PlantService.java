/*package com.gardeningstore.service;

import com.gardeningstore.entity.Plant;
import com.gardeningstore.repository.PlantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlantService {

    @Autowired
    private PlantRepo plantRepo;

    public List<Plant> getAllPlants() {
        return plantRepo.findAll();
    }

    public Optional<Plant> getPlantById(int id) {
        return plantRepo.findById(id);
    }

    public Plant addPlant(Plant plant) {
        return plantRepo.save(plant);
    }

    public void deletePlant(int id) {
        plantRepo.deleteById(id);
    }

    public Plant updatePlant(int id, Plant updatedPlant) {
        Optional<Plant> existingPlantOptional = plantRepo.findById(id);
        if (existingPlantOptional.isPresent()) {
            Plant existingPlant = existingPlantOptional.get();
            existingPlant.setPlantName(updatedPlant.getPlantName());
            existingPlant.setPlantType(updatedPlant.getPlantType());
            existingPlant.setPlantSpecies(updatedPlant.getPlantSpecies());
            existingPlant.setPlantOrigin(updatedPlant.getPlantOrigin());
            existingPlant.setPlantPrice(updatedPlant.getPlantPrice());
            existingPlant.setPlantingSeason(updatedPlant.getPlantingSeason());
            return plantRepo.save(existingPlant);
        }
        return null;
    }
}*/

package com.gardeningstore.service;

import com.gardeningstore.entity.Plant;
import com.gardeningstore.repository.PlantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlantService {

    @Autowired
    private PlantRepo plantRepo;

    public List<Plant> getAllPlants() {
        return plantRepo.findAll();
    }

    public Page<Plant> getAllPlants(Pageable pageable) {
        return plantRepo.findAll(pageable);
    }

    public Optional<Plant> getPlantById(int id) {
        return plantRepo.findById(id);
    }

    public Plant addPlant(Plant plant) {
        return plantRepo.save(plant);
    }

    // public void deletePlant(int id) {
    // plantRepo.deleteById(id);
    // }

    // public Plant updatePlant(int id, Plant updatedPlant) {
    // Optional<Plant> existingPlantOptional = plantRepo.findById(id);
    // if (existingPlantOptional.isPresent()) {
    // Plant existingPlant = existingPlantOptional.get();
    // existingPlant.setPlantName(updatedPlant.getPlantName());
    // existingPlant.setPlantType(updatedPlant.getPlantType());
    // existingPlant.setPlantSpecies(updatedPlant.getPlantSpecies());
    // existingPlant.setPlantOrigin(updatedPlant.getPlantOrigin());
    // existingPlant.setPlantPrice(updatedPlant.getPlantPrice());
    // existingPlant.setPlantingSeason(updatedPlant.getPlantingSeason());
    // return plantRepo.save(existingPlant);
    // }
    // return null;
    // }

    public Page<Plant> findAllPaginatedAndSorted(int pageNo, int pageSize, String sortBy, String direction) {
        Sort sort = Sort.by(Sort.Direction.fromString(direction), sortBy);
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        return plantRepo.findAll(pageable);
    }

}

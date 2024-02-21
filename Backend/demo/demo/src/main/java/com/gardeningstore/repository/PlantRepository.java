// src/main/java/com/gardeningstore/repository/PlantRepository.java

package com.gardeningstore.repository;

import com.gardeningstore.entity.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Long> {
}
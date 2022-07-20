package com.example.onlineplantnursery.Service;

import com.example.onlineplantnursery.Entity.Plant;
import com.example.onlineplantnursery.Repository.PlantRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PlantServiceImpl implements PlantService{

    @Autowired
    private PlantRepository plantRepository;
    private Plant plant;
    @Override
    public Plant addPlant(Plant plant) {
        plantRepository.save(plant);
        return plant;
    }

    @Override
    public Plant updatePlant(Plant plant) {
        return plantRepository.save(plant);
    }

    @Override
    public void deletePlant(Long PlantId) {
        plantRepository.deleteById(PlantId);
    }

    @Override
    public Plant viewPlant(Long plantId) {
        return plantRepository.findById(plantId).get();
    }

    @Override
    public List<Plant> viewPlant(String commonName) {
        return plantRepository.findByCommonName(commonName);
    }

    @Override
    public List<Plant> viewAllPlants() {
        return plantRepository.findAll();
    }

    @Override
    public List<Plant> viewAllPlants(String typeOfPlant) {
        return plantRepository.findByTypeOfPlant(typeOfPlant);
    }
}

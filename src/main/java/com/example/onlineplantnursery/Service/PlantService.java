package com.example.onlineplantnursery.Service;

import com.example.onlineplantnursery.Entity.Plant;

import java.util.List;

public interface PlantService {
    Plant addPlant(Plant plant);

    Plant updatePlant(Plant plant);

    void deletePlant(Long plantId);

    Plant viewPlant(Long plantId);

    List<Plant> viewPlant(String commonName);

    List<Plant> viewAllPlants();

    List<Plant> viewAllPlants(String typeOfPlant);
}

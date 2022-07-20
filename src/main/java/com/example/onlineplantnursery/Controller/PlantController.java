package com.example.onlineplantnursery.Controller;
import com.example.onlineplantnursery.Entity.Plant;
import com.example.onlineplantnursery.Service.PlantServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/plant")
public class PlantController {
    @Autowired
    private PlantServiceImpl plantServiceimpl;

    @PostMapping("/add")
    public ResponseEntity<Plant> addPlant(@RequestBody Plant plant){
        Plant plant1 =plantServiceimpl.addPlant(plant);
        log.info("Added a new Plant ");
        log.info(String.valueOf(plant1));
        return new ResponseEntity<>(plant1, HttpStatus.CREATED);
    }
    @GetMapping("/view")
    public ResponseEntity<Plant> viewPlant(@RequestParam Long plantId){
        Plant plant = plantServiceimpl.viewPlant(plantId);
        return new ResponseEntity<>(plant,HttpStatus.ACCEPTED);
    }
    @GetMapping("/viewall")
    public List<Plant> viewAllPlants(){
        return plantServiceimpl.viewAllPlants();
    }
    @PutMapping("/update")
    public Plant updatePlant(@RequestBody Plant plant){
        return plantServiceimpl.updatePlant(plant);
    }
    @DeleteMapping("/delete")
    public void removePlant(@RequestParam Long plantId){
        plantServiceimpl.deletePlant(plantId);
    }
    @GetMapping("/viewByCommonName")
    public List<Plant> ViewByCommonName(@RequestParam String commonName){
        return plantServiceimpl.viewPlant(commonName);
    }
    @GetMapping("/viewByTypeOfPlant")
    public List<Plant> ViewByTypeOfPlant(@RequestParam String typeOfPlant){
        return plantServiceimpl.viewAllPlants(typeOfPlant);
    }
}

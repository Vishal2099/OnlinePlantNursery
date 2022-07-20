package com.example.onlineplantnursery.Controller;

import com.example.onlineplantnursery.Entity.Planter;
import com.example.onlineplantnursery.Service.PlanterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planter")
public class PlanterController {

    @Autowired
    PlanterService planterService;

    @PostMapping(path = "/add")
    public ResponseEntity<Planter> addPlanter(@RequestBody Planter planter){
        return new ResponseEntity<>(planterService.addPlanter(planter), HttpStatus.CREATED);
    }

    @GetMapping("/viewall")
    public List<Planter> getAllPlanter(){
        return planterService.getAllPlanter();
    }

    @GetMapping("/viewPlanter")
    public ResponseEntity<Planter> getPlanterDetails(@RequestParam(value="id") long id){
        return ResponseEntity.ok().body(planterService.getPlanter(id));
    }

    @DeleteMapping("/delete")
    public void deletePlanter(@RequestParam Long id){
        planterService.removePlanter(id);
    }

    @PutMapping(path = "/update")
    public void modifyplanter(@RequestParam(value = "id") Long id1, @RequestBody Planter planter){
        planterService.updatePlanter(id1 ,planter);
    }

}
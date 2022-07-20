package com.example.onlineplantnursery.Service;

import com.example.onlineplantnursery.Entity.Planter;
import com.example.onlineplantnursery.Repository.PlanterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PlanterService {

    @Autowired
    PlanterRepository planterrepository;

    public Planter addPlanter(Planter planter){
        return  planterrepository.save(planter);
    }

    public List<Planter> getAllPlanter(){
        return planterrepository.findAll();
    }

    public Planter getPlanter(long id) {
        Optional<Planter> planterService =planterrepository.findById(id);
        if(planterService.isPresent()) return planterService.get();
        else throw new IllegalStateException("Planter doesnt exists!!!");
    }

    public void removePlanter(Long id){
        planterrepository.deleteById(id);
    }

    @Transactional
    public void updatePlanter(Long id,Planter planter){
        Optional<Planter> planter1 =planterrepository.findById(id);
        if(planter1.isPresent()){
            planter1.get().setPlanterHeight(planter.getPlanterHeight());
            planter1.get().setPlanterCapacity(planter.getPlanterCapacity());
            planter1.get().setDrainageHoles(planter.getDrainageHoles());
            planter1.get().setPlanterColor(planter.getPlanterColor());
            planter1.get().setPlanterShaper(planter.getPlanterShaper());
            planter1.get().setPlanterStock(planter.getPlanterStock());
            planter1.get().setPlanterCost(planter.getPlanterCost());
            planter1.get().setPlants(planter.getPlants());
        }
        else throw new IllegalStateException("Planter: "+id+ " doesnt exists!");
    }



}

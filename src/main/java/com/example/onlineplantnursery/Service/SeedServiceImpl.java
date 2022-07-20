package com.example.onlineplantnursery.Service;

import com.example.onlineplantnursery.Entity.Seed;
import com.example.onlineplantnursery.Repository.SeedRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SeedServiceImpl implements SeedService {

    @Autowired
    private SeedRepository seedRepository;
    private Seed seed;
    @Override
    public Seed addSeed(Seed seed) {
        seedRepository.save(seed);
        return seed;
    }

    @Override
    public Seed updateSeed(Seed seed) {
        return seedRepository.save(seed);
    }

    @Override
    public void deleteSeed(Long SeedId) {
        seedRepository.deleteById(SeedId);
    }

    @Override
    public Seed viewSeed(Long seedId) {
        return seedRepository.findById(seedId).get();
    }

    @Override
    public List<Seed> viewPlant(String commonName) {
        return seedRepository.findByCommonName(commonName);
    }

    @Override
    public List<Seed> viewAllSeeds() {
        return seedRepository.findAll();
    }

    @Override
    public List<Seed> viewAllSeeds(String typeOfSeed) {
        return seedRepository.findByTypeOfSeed(typeOfSeed);
    }
}
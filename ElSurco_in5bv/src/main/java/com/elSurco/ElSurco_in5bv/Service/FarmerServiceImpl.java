package com.elSurco.ElSurco_in5bv.Service;

import com.elSurco.ElSurco_in5bv.Entity.Farmer;
import com.elSurco.ElSurco_in5bv.Repository.FarmerRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FarmerServiceImpl implements FarmerService {

    private final FarmerRepository farmerRepository;
    private final GoogleMapsService googleMapsService;

    public FarmerServiceImpl(FarmerRepository farmerRepository, GoogleMapsService googleMapsService) {
        this.farmerRepository = farmerRepository;
        this.googleMapsService = googleMapsService;
    }

    @Override
    public List<Farmer> getAll() { return farmerRepository.findAll(); }

    @Override
    public Farmer getById(Integer id) {
        return farmerRepository.findById(id).orElseThrow(() -> new RuntimeException("Farmer with wrong ID"));
    }

    @Override
    public Farmer create(Farmer farmer) {
        farmer.setIdFarmer(null);
        if (farmer.getFarmerAddress() != null && farmer.getFarmerGps() == null) {
            String coordinates = googleMapsService.getCoordinates(farmer.getFarmerAddress());
            farmer.setFarmerGps(coordinates);
        }
        return farmerRepository.save(farmer);
    }

    @Override
    public Farmer update(Integer id, Farmer farmer) {
        Farmer existingFarmer = farmerRepository.findById(id).orElse(null);
        if (existingFarmer != null){
            existingFarmer.setFarmerName(farmer.getFarmerName());
            existingFarmer.setFarmerLastName(farmer.getFarmerLastName());
            existingFarmer.setFarmerIdCard(farmer.getFarmerIdCard());
            existingFarmer.setFarmerPhone(farmer.getFarmerPhone());
            existingFarmer.setFarmerAddress(farmer.getFarmerAddress());

            if(farmer.getFarmerGps() != null) {
                existingFarmer.setFarmerGps(farmer.getFarmerGps());
            } else {
                String coordinates = googleMapsService.getCoordinates(farmer.getFarmerAddress());
                existingFarmer.setFarmerGps(coordinates);
            }

            existingFarmer.setFarmerStory(farmer.getFarmerStory());
            existingFarmer.setLoginId(farmer.getLoginId());

            return farmerRepository.save(existingFarmer);
        }
        return null;
    }

    @Override
    public void delete(Integer id) { farmerRepository.deleteById(id); }
}
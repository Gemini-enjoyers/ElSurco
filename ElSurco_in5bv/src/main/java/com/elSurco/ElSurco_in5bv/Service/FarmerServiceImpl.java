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
    public List<Farmer> getAll() {
        return farmerRepository.findAll();
    }

    @Override
    public Farmer getById(Integer id) {
        return farmerRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Farmer with ID " + id + " not found."));
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
        Farmer existingFarmer = getById(id);

        boolean addressChanged = !existingFarmer.getFarmerAddress().equals(farmer.getFarmerAddress());

        existingFarmer.setFarmerFirstName(farmer.getFarmerFirstName());
        existingFarmer.setFarmerLastName(farmer.getFarmerLastName());
        existingFarmer.setFarmerDpi(farmer.getFarmerDpi());
        existingFarmer.setFarmerPhone(farmer.getFarmerPhone());
        existingFarmer.setFarmerAddress(farmer.getFarmerAddress());
        existingFarmer.setFarmerHistory(farmer.getFarmerHistory());

        if (farmer.getFarmerGps() != null) {
            existingFarmer.setFarmerGps(farmer.getFarmerGps());
        } else if (addressChanged) {
            String coordinates = googleMapsService.getCoordinates(farmer.getFarmerAddress());
            existingFarmer.setFarmerGps(coordinates);
        }

        existingFarmer.setUser(farmer.getUser());

        return farmerRepository.save(existingFarmer);
    }

    @Override
    public void delete(Integer id) {
        Farmer existingFarmer = getById(id);
        farmerRepository.delete(existingFarmer);
    }
}
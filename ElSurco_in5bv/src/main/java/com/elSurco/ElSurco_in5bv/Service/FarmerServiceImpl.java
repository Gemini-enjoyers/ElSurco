package com.elSurco.ElSurco_in5bv.Service;

import com.elSurco.ElSurco_in5bv.Entity.Farmer;
import com.elSurco.ElSurco_in5bv.Entity.User;
import com.elSurco.ElSurco_in5bv.Repository.FarmerRepository;
import com.elSurco.ElSurco_in5bv.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FarmerServiceImpl implements FarmerService {

    private final FarmerRepository farmerRepository;
    private final GoogleMapsService googleMapsService;
    private final UserRepository userRepository;

    public FarmerServiceImpl(FarmerRepository farmerRepository, GoogleMapsService googleMapsService, UserRepository userRepository) {
        this.farmerRepository = farmerRepository;
        this.googleMapsService = googleMapsService;
        this.userRepository = userRepository;
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

    @Override
    @Transactional // Asegura la integridad total de la transacción en MySQL
    public void createFarmerProfile(String email, String firstName, String lastName, String dpi, Long phone, String address, String history) {

        // 1. Buscamos el usuario logueado en la base de datos
        User user = userRepository.findByUserEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado en el sistema."));

        // 2. Construimos la entidad Farmer asignando cada propiedad de tu DB
        Farmer farmer = new Farmer();
        farmer.setFarmerFirstName(firstName);
        farmer.setFarmerLastName(lastName);
        farmer.setFarmerDpi(dpi);
        farmer.setFarmerPhone(phone);
        farmer.setFarmerAddress(address);
        farmer.setFarmerHistory(history);
        farmer.setRegistrationDate(LocalDate.now()); // Equivalente a tu (CURRENT_DATE)

        // 🤝 ASOCIACIÓN DE LLAVE FORÁNEA: Vinculamos el objeto User completo
        farmer.setUser(user);

        // 3. Lógica automática de Geolocalización que ya habías desarrollado
        if (address != null) {
            String coordinates = googleMapsService.getCoordinates(address);
            farmer.setFarmerGps(coordinates);
        }

        // 4. Persistimos en la tabla Farmers de MySQL
        farmerRepository.save(farmer);
    }
}
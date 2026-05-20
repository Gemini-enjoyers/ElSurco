package com.elSurco.ElSurco_in5bv.Service;
import com.elSurco.ElSurco_in5bv.Entity.Farmer;
import java.util.List;

public interface FarmerService {
    List<Farmer> getAll();
    Farmer getById(Integer id);
    Farmer create(Farmer farmer);
    Farmer update(Integer id, Farmer farmer);
    void delete(Integer id);
    void createFarmerProfile(String email, String firstName, String lastName, String dpi, Long phone, String address, String history);
}
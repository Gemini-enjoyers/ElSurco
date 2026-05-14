package com.elSurco.ElSurco_in5bv.Controller;

import com.elSurco.ElSurco_in5bv.Entity.Farmer;
import com.elSurco.ElSurco_in5bv.Service.FarmerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/farmer")
public class FarmerController {

    private final FarmerService farmerService;

    public FarmerController(FarmerService farmerService) {
        this.farmerService = farmerService;
    }

    @GetMapping("/getAll")
    public List<Farmer> getAll(){
        return farmerService.getAll();
    }

    @GetMapping("/{id}")
    public Farmer getById(@PathVariable Integer id){
        return farmerService.getById(id);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Farmer create (@Valid @RequestBody Farmer farmer){
        return farmerService.create(farmer);
    }

    @PutMapping("/update/{id}")
    public Farmer update(@PathVariable("id") Integer id, @RequestBody Farmer farmer){
        return farmerService.update(id, farmer);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        farmerService.delete(id);
    }
}
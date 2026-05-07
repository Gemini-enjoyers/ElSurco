package com.elSurco.ElSurco_in5bv.Controller;

import com.elSurco.ElSurco_in5bv.Entity.Agricultor;
import com.elSurco.ElSurco_in5bv.Service.FarmerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agricultor")
public class AgricultorController {

    private final FarmerService farmerService;

    public AgricultorController(FarmerService farmerService) {
        this.farmerService = farmerService;
    }

    @GetMapping("/get")
    public List<Agricultor> listar(){
        return farmerService.listar();
    }

    @GetMapping("/{id}")
    public Agricultor obtener(@PathVariable Integer id){
        return farmerService.obtenerPorId(id);
    }

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.CREATED)
    public Agricultor crear (@Valid @RequestBody Agricultor agricultor){
        return farmerService.agregar(agricultor);
    }

    @PutMapping("/put/{Id}")
    public Agricultor actualizar(@PathVariable("Id") Integer id, @RequestBody Agricultor agricultor){
        return farmerService.actualizar(id, agricultor);
    }

    @DeleteMapping("/{id}")
    public Agricultor eliminar(@PathVariable Integer id) {
        farmerService.eliminar(id);
        return null;
    }

}

package com.elSurco.ElSurco_in5bv.Controller;

import com.elSurco.ElSurco_in5bv.Entity.Agricultor;
import com.elSurco.ElSurco_in5bv.Service.AgricultorService;
import org.hibernate.cfg.AgroalSettings;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agricultor")
public class AgricultorController {

    private final AgricultorService agricultorService;

    public AgricultorController(AgricultorService agricultorService) {
        this.agricultorService = agricultorService;
    }

    @GetMapping("/get")
    public List<Agricultor> listar(){
        return agricultorService.listar();
    }

    @GetMapping("/{id}")
    public Agricultor obtener(@PathVariable Integer id){
        return agricultorService.obtenerPorId(id);
    }

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.CREATED)
    public Agricultor crear (@RequestBody Agricultor agricultor){
        return agricultorService.agregar(agricultor);
    }

    @PutMapping("/put/{Id}")
    public Agricultor actualizar(@RequestBody Integer id, @RequestBody Agricultor agricultor){
        return agricultorService.actualizar(id, agricultor);
    }

    @DeleteMapping("/{id}")
    public List<Agricultor> lista(){
        return agricultorService.listar();
    }

}

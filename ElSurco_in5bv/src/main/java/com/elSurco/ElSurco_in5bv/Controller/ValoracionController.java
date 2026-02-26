package com.elSurco.ElSurco_in5bv.Controller;
import com.elSurco.ElSurco_in5bv.Entity.Valoracion;
import com.elSurco.ElSurco_in5bv.Service.ValoracionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/voloracion")
public class ValoracionController {
    private final ValoracionService valoracionService;

    public ValoracionController(ValoracionService valoracionService){
        this.valoracionService = valoracionService;
    }

    @GetMapping("/get")
    public List<Valoracion> listar(){
        return valoracionService.listar();
    }

    @GetMapping("/{id}")
    public Valoracion obtener(@PathVariable Integer id){
        return valoracionService.obtenerPorId(id);
    }

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.CREATED)
    public Valoracion crear(@RequestBody Valoracion valoracion){
        return  valoracionService.agregar(valoracion);
    }

    @PutMapping("/put/{id}")
    public Valoracion actualizar(@PathVariable("Id") Integer id, @RequestBody Valoracion valoracion){
        return valoracionService.actualizar(id, valoracion);
    }

    @DeleteMapping("/{id}")
    public Valoracion eliminar(@PathVariable Integer id){
        valoracionService.eliminar(id);
        return null;
    }
}

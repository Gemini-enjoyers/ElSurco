package com.elSurco.ElSurco_in5bv.Controller;
import com.elSurco.ElSurco_in5bv.Entity.Verduras;
import com.elSurco.ElSurco_in5bv.Service.VerdurasService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/verduras")
public class VerdurasConroller {

    private final VerdurasService verdurasService;

    public VerdurasConroller(VerdurasService verdurasService){
        this.verdurasService = verdurasService;
    }

    @GetMapping("/get")
    public  List<Verduras> listar(){ return verdurasService.listar();}

    @GetMapping("/{id}")
    public Verduras obtener(@PathVariable Integer id) {return verdurasService.obtenerporid(id);}

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.CREATED)
    public Verduras crear(@RequestBody Verduras verduras) {
        return verdurasService.crear(verduras);

    }

    @PutMapping("/put/{id}")
    public Verduras actualizar (@PathVariable Integer id, @RequestBody Verduras verduras) {
        return verdurasService.actualizar(id, verduras);
    }
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Integer id) {
        verdurasService.eliminar(id);
    }
}

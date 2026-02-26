package com.elSurco.ElSurco_in5bv.Controller;
import com.elSurco.ElSurco_in5bv.Entity.Frutas;
import com.elSurco.ElSurco_in5bv.Entity.Verduras;
import com.elSurco.ElSurco_in5bv.Service.FrutasService;
import com.elSurco.ElSurco_in5bv.Service.VerdurasService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/frutas")
public class FrutasController {
    private final FrutasService frutasService;

    public FrutasController(FrutasService frutasService){
        this.frutasService = frutasService;
    }

    @GetMapping("/get")
    public  List<Frutas> listar(){ return frutasService.listar();}

    @GetMapping("/{id}")
    public Frutas obtener(@PathVariable Integer id) {return frutasService.obtenerporid(id);}

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.CREATED)
    public Frutas crear(@RequestBody Frutas frutas) {
        return frutasService.crear(frutas);

    }

    @PutMapping("/put/{id}")
    public Frutas actualizar (@PathVariable Integer id, @RequestBody Frutas frutas) {
        return frutasService.actualizar(id, frutas);
    }
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Integer id) {
        frutasService.eliminar(id);
    }
}

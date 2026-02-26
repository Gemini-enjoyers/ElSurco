package com.elSurco.ElSurco_in5bv.Controller;
import com.elSurco.ElSurco_in5bv.Entity.Facturas;
import com.elSurco.ElSurco_in5bv.Service.FacturasService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import  java.util.List;

@RestController
@RequestMapping ("/api/factura")
public class FacturaController {
    private final FacturasService facturasService;

    public FacturaController(FacturasService facturasService){
        this.facturasService = facturasService;
    }

    @GetMapping("/get")
    public List<Facturas> listar(){return  facturasService.listar();}

    @GetMapping("/{id}")
    public Facturas obtener(@PathVariable Integer id){return facturasService.obtenerporid(id);}

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.CREATED)
    public Facturas crear(@RequestBody Facturas facturas){
        return facturasService.crear(facturas);
    }

    @PutMapping("/put/{id}")
    public Facturas actualizar (@PathVariable Integer id, @RequestBody Facturas facturas){
        return facturasService.actualizar(id, facturas);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Integer id){
        facturasService.eliminar(id);
    }

}

package com.elSurco.ElSurco_in5bv.Controller;

import com.elSurco.ElSurco_in5bv.Entity.Comprador;
import com.elSurco.ElSurco_in5bv.Service.CompradorService;
import com.elSurco.ElSurco_in5bv.Entity.Comprador;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@RestController
@RequestMapping("/api/comprador")
public class CompradorController {

   private final CompradorService compradorService;
   public CompradorController(CompradorService compradorService){this.compradorService = compradorService;}
    @GetMapping("/get")
    public List<Comprador> listar () {return compradorService.listar();}
    @GetMapping ("/{id}")
    public Comprador obtener(@PathVariable Integer id) { return compradorService.obtenerPorId(id);}
   @PostMapping("/post")
   @ResponseStatus (HttpStatus.CREATED)
   public Comprador crear(@RequestBody Comprador comprador) {return compradorService.crear(comprador);}
   @PutMapping ("/put/{id}")
   public Comprador actualizar (@PathVariable Integer id, @RequestBody Comprador comprador) {
       return compradorService.actualizar(id, comprador);
   }
   @DeleteMapping ("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void  eliminar(@PathVariable Integer id) { compradorService.eliminar(id);}
}

package com.elSurco.ElSurco_in5bv.Service;
import com.elSurco.ElSurco_in5bv.Repository.VerdurasRepositoty;
import com.elSurco.ElSurco_in5bv.Entity.Verduras;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VerdurasServiceImplement implements VerdurasService{
private final VerdurasRepositoty verdurasRepositoty;

    public VerdurasServiceImplement (VerdurasRepositoty getVerdurasRepository){
        this.verdurasRepositoty = getVerdurasRepository;
    }

    @Override
    public List<Verduras> listar(){return verdurasRepositoty.findAll();}

    @Override
    public Verduras obtenerporid(Integer Id){
        return verdurasRepositoty.findById(Id).orElseThrow(() -> new RuntimeException("usuadhfadhbs"));
    }

    @Override
    public Verduras crear(Verduras verduras){
        verduras.setIdverdura(null);
        return verdurasRepositoty.save(verduras);
    }

    @Override
    public Verduras actualizar(Integer id, Verduras verduras) {
        Verduras existente = obtenerporid(id);
        existente.setNombre(verduras.getNombre());
        existente.setDescripcion(verduras.getDescripcion());
        return verdurasRepositoty.save (existente);
    }

    @Override
    public void eliminar(Integer id){
        Verduras existente = obtenerporid(id);
        verdurasRepositoty.delete(existente);
    }
}

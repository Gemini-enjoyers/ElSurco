package com.elSurco.ElSurco_in5bv.Service;
import com.elSurco.ElSurco_in5bv.Repository.FrutasRepositoty;
import com.elSurco.ElSurco_in5bv.Entity.Frutas;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public abstract class FrutasServiceImplement implements FrutasService{
    private FrutasRepositoty frutasRepositoty;

    public void FrutasRepositoty (FrutasRepositoty getFrutasRepository){
        this.frutasRepositoty = getFrutasRepository;
    }

    public FrutasServiceImplement(FrutasRepositoty frutasRepositoty) {
        this.frutasRepositoty = frutasRepositoty;
    }

    @Override
    public List<Frutas> listar(){return frutasRepositoty.findAll();}

    @Override
    public Frutas obtenerporid(Integer Id){
        return frutasRepositoty.findById(Id).orElseThrow(() -> new RuntimeException("usuadhfadhbs"));
    }

    @Override
    public Frutas crear(Frutas frutas){
        frutas.setIdfrutas(null);
        return frutasRepositoty.save(frutas);
    }

    @Override
    public Frutas actualizar(Integer id, Frutas frutas) {
        Frutas existente = obtenerporid(id);
        existente.setNombre(frutas.getNombre());
        existente.setDescripcion(frutas.getDescripcion());
        return frutasRepositoty.save (existente);
    }

    @Override
    public void eliminar(Integer id){
        Frutas existente = obtenerporid(id);
        frutasRepositoty.delete(existente);
    }
}

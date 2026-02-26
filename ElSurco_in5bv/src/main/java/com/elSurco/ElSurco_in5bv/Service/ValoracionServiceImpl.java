package com.elSurco.ElSurco_in5bv.Service;
import com.elSurco.ElSurco_in5bv.Entity.Valoracion;
import com.elSurco.ElSurco_in5bv.Repository.ValoracionRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ValoracionServiceImpl implements ValoracionService{
    private final ValoracionRepository valoracionRepository;

    public ValoracionServiceImpl(ValoracionRepository valoracionRepository){
        this.valoracionRepository = valoracionRepository;
    }

    @Override
    public List<Valoracion> listar(){
        return valoracionRepository.findAll();
    }

    @Override
    public  Valoracion obtenerPorId(Integer id){
        return valoracionRepository.findById(id).orElseThrow(() -> new RuntimeException("Valores con Id Errónio"));
    }

    @Override
    public Valoracion agregar(Valoracion valoracion){
        valoracion.setIdValoracion(null);
        return valoracionRepository.save(valoracion);
    }

    @Override
    public Valoracion actualizar(Integer id, Valoracion valoracion){
        Valoracion existente = valoracionRepository.findById(id).orElse(null);
        if (existente != null){
            existente.setComentarioValoracion(valoracion.getComentarioValoracion());
            existente.setPuntuacionValoracion(valoracion.getPuntuacionValoracion());
            existente.setFechaValoraciom(valoracion.getFechaValoraciom());
            return valoracionRepository.save(existente);
        }
        return  null;
    }

    @Override
    public void eliminar(Integer id){
        valoracionRepository.deleteById(id);
    }
}

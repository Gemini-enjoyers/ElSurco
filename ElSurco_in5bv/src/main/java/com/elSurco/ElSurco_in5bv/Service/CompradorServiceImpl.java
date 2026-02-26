package com.elSurco.ElSurco_in5bv.Service;


import com.elSurco.ElSurco_in5bv.Entity.Comprador;
import com.elSurco.ElSurco_in5bv.Repository.CompradorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompradorServiceImpl implements CompradorService {
    private final CompradorRepository compradorRepository;

    public CompradorServiceImpl(CompradorRepository compradorRepository) {
        this.compradorRepository = compradorRepository;
    }
    @Override
    public List<Comprador> listar() {return compradorRepository.findAll(); }

    @Override
    public  Comprador obtenerPorId(Integer Id) {
        return  compradorRepository.findById(Id).orElseThrow(() -> new RuntimeException("Usuario "+Id+" no encontrado."));

    }
    @Override
    public Comprador crear(Comprador comprador) {
        comprador.setIdComprador(null);
        return  compradorRepository.save(comprador);
    }

    @Override
    public Comprador actualizar(Integer id, Comprador comprador) {
     Comprador existente = obtenerPorId(id);
     existente.setNombres(comprador.getNombres());
     existente.setApellidos(comprador.getApellidos());
     existente.setTelefono(comprador.getTelefono());
     existente.setDireccionEntrega(comprador.getDireccionEntrega());
     return compradorRepository.save(existente);
    }
    @Override
    public void eliminar(Integer id) {
      Comprador existente = obtenerPorId(id);
      compradorRepository.delete(existente);
    }

}

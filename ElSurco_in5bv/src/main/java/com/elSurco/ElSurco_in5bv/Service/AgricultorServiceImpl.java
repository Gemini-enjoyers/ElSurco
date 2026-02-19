package com.elSurco.ElSurco_in5bv.Service;

import com.elSurco.ElSurco_in5bv.Entity.Agricultor;
import com.elSurco.ElSurco_in5bv.Repository.AgricultorRepository;

import java.util.List;

public class AgricultorServiceImpl implements AgricultorService{
    private final AgricultorRepository agricultorRepository;


    public AgricultorServiceImpl(AgricultorRepository agricultorRepository) {
        this.agricultorRepository = agricultorRepository;
    }

    @Override
    public List<Agricultor> listar() {
        return agricultorRepository.findAll();
    }

    @Override
    public Agricultor obtenerPorId(Integer Id) {
        return agricultorRepository.findById(Id).orElseThrow(() -> new RuntimeException("Agricultor con ID Erroneo"));
    }

    @Override
    public Agricultor agregar(Agricultor agricultor) {
        agricultor.setIdAgricultor(null);
        return agricultorRepository.save(agricultor);
    }

    @Override
    public Agricultor actualizar(Integer id, Agricultor agricultor) {
        Agricultor agricultorExistente = agricultorRepository.findById(id).orElse(null);
        if (agricultorExistente != null){
            agricultorExistente.setNombres(agricultor.getNombres());
            agricultorExistente.setApellidos(agricultor.getApellidos());
            agricultorExistente.setDpi(agricultor.getDpi());
            agricultorExistente.setTelefono(agricultor.getTelefono());
            agricultorExistente.setComunidadAldea(agricultor.getComunidadAldea());
            agricultorExistente.setCoordenadasGps(agricultor.getCoordenadasGps());
            agricultorExistente.setHistoriaPerfil(agricultor.getHistoriaPerfil());
            agricultorExistente.setIdLogin(agricultor.getIdLogin());
        }
        return null;
    }

    @Override
    public void eliminar(Integer id) {
        agricultorRepository.deleteById(id);
    }
}

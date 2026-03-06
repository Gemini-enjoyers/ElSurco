package com.elSurco.ElSurco_in5bv.Service;

import com.elSurco.ElSurco_in5bv.Entity.Agricultor;
import com.elSurco.ElSurco_in5bv.Repository.AgricultorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgricultorServiceImpl implements AgricultorService{

    private final AgricultorRepository agricultorRepository;
    private final GoogleMapsService googleMapsService;

    public AgricultorServiceImpl(AgricultorRepository agricultorRepository, GoogleMapsService googleMapsService) {
        this.agricultorRepository = agricultorRepository;
        this.googleMapsService = googleMapsService;
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

        if (agricultor.getDireccionAgricultor() != null && agricultor.getGpsAgricultor() == null) {
            String coordenadas = googleMapsService.obtenerCoordenadas(agricultor.getDireccionAgricultor());
            agricultor.setGpsAgricultor(coordenadas);
        }

        return agricultorRepository.save(agricultor);
    }

    @Override
    public Agricultor actualizar(Integer id, Agricultor agricultor) {
        Agricultor agricultorExistente = agricultorRepository.findById(id).orElse(null);
        if (agricultorExistente != null){
            agricultorExistente.setNombreAgricultor(agricultor.getNombreAgricultor());
            agricultorExistente.setApellidoAgricultor(agricultor.getApellidoAgricultor());
            agricultorExistente.setDpiAgricultor(agricultor.getDpiAgricultor());
            agricultorExistente.setTelefonoAgricultor(agricultor.getTelefonoAgricultor());
            agricultorExistente.setDireccionAgricultor(agricultor.getDireccionAgricultor());

            if(agricultor.getGpsAgricultor() != null) {
                agricultorExistente.setGpsAgricultor(agricultor.getGpsAgricultor());
            } else {
                String coordenadas = googleMapsService.obtenerCoordenadas(agricultor.getDireccionAgricultor());
                agricultorExistente.setGpsAgricultor(coordenadas);
            }

            agricultorExistente.setHistoriaAgricultor(agricultor.getHistoriaAgricultor());
            agricultorExistente.setIdLogin(agricultor.getIdLogin());

            return agricultorRepository.save(agricultorExistente);
        }
        return null;
    }

    @Override
    public void eliminar(Integer id) {
        agricultorRepository.deleteById(id);
    }
}
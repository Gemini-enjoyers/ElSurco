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

        if (agricultor.getComunidadAldea() != null && agricultor.getCoordenadasGps() == null) {
            String coordenadas = googleMapsService.obtenerCoordenadas(agricultor.getComunidadAldea());
            agricultor.setCoordenadasGps(coordenadas);
        }

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

            if(agricultor.getCoordenadasGps() != null) {
                agricultorExistente.setCoordenadasGps(agricultor.getCoordenadasGps());
            } else {
                String coordenadas = googleMapsService.obtenerCoordenadas(agricultor.getComunidadAldea());
                agricultorExistente.setCoordenadasGps(coordenadas);
            }

            agricultorExistente.setHistoriaPerfil(agricultor.getHistoriaPerfil());
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
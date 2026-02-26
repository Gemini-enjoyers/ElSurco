package com.elSurco.ElSurco_in5bv.Service;

import com.elSurco.ElSurco_in5bv.Entity.Login;
import java.util.List;
import java.util.Optional;

public interface LoginService {
    List<Login> listar();
    Login obtenerPorId(Integer id);
    Login agregar(Login login);
    Login actualizar(Integer id, Login login);
    void eliminar(Integer id);

    Optional<Login> obtenerPorEmail(String email);
}
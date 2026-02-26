package com.elSurco.ElSurco_in5bv.Service;

import com.elSurco.ElSurco_in5bv.Entity.Login;
import java.util.List;
import java.util.Optional;

public interface LoginService {
    List<Login> findAll();
    Login findById(Integer id);
    Login save(Login login);
    void delete(Integer id);
    Optional<Login> findByEmailLogin(String email);
}

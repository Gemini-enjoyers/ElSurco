package com.elSurco.ElSurco_in5bv.Service;

import com.elSurco.ElSurco_in5bv.Entity.Login;
import java.util.List;
import java.util.Optional;

public interface LoginService {
    List<Login> getAll();
    Login getById(Integer id);
    Login create(Login login);
    Login update(Integer id, Login login);
    void delete(Integer id);
    Optional<Login> getByEmail(String email);
}
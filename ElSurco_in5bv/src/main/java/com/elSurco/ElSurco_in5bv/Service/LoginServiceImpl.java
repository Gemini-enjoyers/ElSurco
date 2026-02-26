package com.elSurco.ElSurco_in5bv.Service;

import com.elSurco.ElSurco_in5bv.Entity.Login;
import com.elSurco.ElSurco_in5bv.Repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginRepository loginRepository;

    @Override
    public List<Login> findAll() {
        return loginRepository.findAll();
    }

    @Override
    public Login findById(Integer id) {
        return loginRepository.findById(id).orElse(null);
    }

    @Override
    public Login save(Login login) {
        return loginRepository.save(login);
    }

    @Override
    public void delete(Integer id) {
        loginRepository.deleteById(id);
    }

    @Override
    public Optional<Login> findByEmailLogin(String email) {
        return loginRepository.findByEmailLogin(email);
    }
}
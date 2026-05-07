package com.elSurco.ElSurco_in5bv.Service;

import com.elSurco.ElSurco_in5bv.Entity.Login;
import com.elSurco.ElSurco_in5bv.Repository.LoginRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    private final LoginRepository loginRepository;

    public LoginServiceImpl(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public List<Login> getAll() {
        return loginRepository.findAll();
    }

    @Override
    public Login getById(Integer id) {
        return loginRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Login User with wrong ID"));
    }

    @Override
    public Login create(Login login) {
        login.setIdLogin(null);
        return loginRepository.save(login);
    }

    @Override
    public Login update(Integer id, Login login) {
        Login existingLogin = loginRepository.findById(id).orElse(null);

        if (existingLogin != null) {
            existingLogin.setLoginEmail(login.getLoginEmail());
            existingLogin.setLoginPassword(login.getLoginPassword());
            existingLogin.setUserRole(login.getUserRole());

            return loginRepository.save(existingLogin);
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        loginRepository.deleteById(id);
    }

    @Override
    public Optional<Login> getByEmail(String email) {
        return loginRepository.findByLoginEmail(email);
    }
}
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
    public List<Login> listar() {
        return loginRepository.findAll();
    }

    @Override
    public Login obtenerPorId(Integer id) {
        return loginRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario Login con ID Erróneo"));
    }

    @Override
    public Login agregar(Login login) {
        login.setIdLogin(null);
        return loginRepository.save(login);
    }

    @Override
    public Login actualizar(Integer id, Login login) {
        Login loginExistente = loginRepository.findById(id).orElse(null);

        if (loginExistente != null) {
            loginExistente.setEmailLogin(login.getEmailLogin());
            loginExistente.setPasswordLogin(login.getPasswordLogin());
            loginExistente.setRolUsuario(login.getRolUsuario());

            return loginRepository.save(loginExistente);
        }
        return null;
    }

    @Override
    public void eliminar(Integer id) {
        loginRepository.deleteById(id);
    }

    @Override
    public Optional<Login> obtenerPorEmail(String email) {
        return loginRepository.findByEmailLogin(email);
    }
}
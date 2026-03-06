package com.elSurco.ElSurco_in5bv.Service;

import com.elSurco.ElSurco_in5bv.Entity.Login;
import com.elSurco.ElSurco_in5bv.Repository.LoginRepository;
import com.elSurco.ElSurco_in5bv.dto.LoginRequest;
import com.elSurco.ElSurco_in5bv.dto.LoginResponse;
import com.elSurco.ElSurco_in5bv.dto.RegisterRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final LoginRepository loginRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(LoginRepository loginRepository, PasswordEncoder passwordEncoder) {
        this.loginRepository = loginRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void register (RegisterRequest req) {
        if (loginRepository.existsByEmailLogin(req.email)) {
            throw new IllegalArgumentException("El email ya está registrado.");
        }

        String hash = passwordEncoder.encode(req.password);
        Login nuevoLogin = new Login(req.email, hash, req.rolUsuario);
        loginRepository.save(nuevoLogin);
    }

    public LoginResponse login (LoginRequest req) {
        Login loginEntity = loginRepository.findByEmailLogin(req.email)
                .orElseThrow(() -> new IllegalArgumentException("Correo Incorrecto / no existe."));

        boolean ok = passwordEncoder.matches(req.password, loginEntity.getPasswordLogin());
        if (!ok) throw new IllegalArgumentException("Contraseña incorrecta");

        return new LoginResponse(
                "Login correcto",
                loginEntity.getIdLogin(),
                loginEntity.getEmailLogin(),
                loginEntity.getRolUsuario()
        );
    }
}

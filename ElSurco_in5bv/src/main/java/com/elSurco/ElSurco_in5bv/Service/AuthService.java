package com.elSurco.ElSurco_in5bv.Service;

import com.elSurco.ElSurco_in5bv.Entity.Login;
import com.elSurco.ElSurco_in5bv.Repository.LoginRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService {
    private final LoginRepository loginRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(LoginRepository loginRepository, PasswordEncoder passwordEncoder) {
        this.loginRepository = loginRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(Login login) {
        if (loginRepository.existsByLoginEmail(login.getLoginEmail())) {
            throw new IllegalArgumentException("Email is already registered.");
        }

        // Encriptar la contraseña usando lo que enseñó el profe
        String hash = passwordEncoder.encode(login.getLoginPassword());
        login.setLoginPassword(hash);

        loginRepository.save(login);
    }

    public Map<String, Object> login(Login loginRequest) {
        Login loginEntity = loginRepository.findByLoginEmail(loginRequest.getLoginEmail())
                .orElseThrow(() -> new IllegalArgumentException("Incorrect email / does not exist."));

        boolean isMatch = passwordEncoder.matches(loginRequest.getLoginPassword(), loginEntity.getLoginPassword());
        if (!isMatch) throw new IllegalArgumentException("Incorrect password");

        // Devolvemos un Map en lugar del DTO que eliminaste
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Login successful");
        response.put("idLogin", loginEntity.getIdLogin());
        response.put("email", loginEntity.getLoginEmail());
        response.put("userRole", loginEntity.getUserRole());

        return response;
    }
}
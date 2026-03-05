package com.elSurco.ElSurco_in5bv.Service;

import com.elSurco.ElSurco_in5bv.Repository.LoginRepository;
import com.elSurco.ElSurco_in5bv.dto.RegisterRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final LoginRepository LoginRepository ;
    private final PasswordEncoder passwordEncoder;

    public AuthService(LoginRepository loginRepository, PasswordEncoder passwordEncoder) {
        LoginRepository = loginRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void register (RegisterRequest req){
        if (LoginRepository.existsByEmail(req.email)){
    }
}

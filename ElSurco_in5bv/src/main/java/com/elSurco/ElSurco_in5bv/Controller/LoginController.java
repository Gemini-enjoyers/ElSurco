package com.elSurco.ElSurco_in5bv.Controller;

import com.elSurco.ElSurco_in5bv.Service.AuthService;
import com.elSurco.ElSurco_in5bv.Service.LoginService;
import com.elSurco.ElSurco_in5bv.dto.LoginRequest;
import com.elSurco.ElSurco_in5bv.dto.LoginResponse;
import com.elSurco.ElSurco_in5bv.dto.RegisterRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class LoginController {

    private final AuthService authService;

    public LoginController(AuthService authService) {
        this.authService = authService;
    }


    @PostMapping("/register")
    public String register(@Valid @RequestBody RegisterRequest req) {
        authService.register(req);
        return "Usuario registrado correctamente.";
    }

    // Endpoint para loguear: POST a http://localhost:8080/api/auth/login
    @PostMapping("/login")
    public LoginResponse login(@Valid @RequestBody LoginRequest req) {
        return authService.login(req);
    }
}

package com.elSurco.ElSurco_in5bv.Controller;

import com.elSurco.ElSurco_in5bv.Entity.Login;
import com.elSurco.ElSurco_in5bv.Service.AuthService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public String register(@Valid @RequestBody Login login) {
        authService.register(login);
        return "User registered successfully.";
    }

    @PostMapping("/login")
    public Map<String, Object> login(@Valid @RequestBody Login login) {
        return authService.login(login);
    }
}
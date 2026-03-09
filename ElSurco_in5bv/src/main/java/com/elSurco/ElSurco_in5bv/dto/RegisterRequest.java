package com.elSurco.ElSurco_in5bv.dto;

import com.elSurco.ElSurco_in5bv.Util.Rol;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class RegisterRequest {
    @Email
    @NotBlank
    public String email;

    @NotBlank
    public String password;

    @NotNull
    public Rol rolUsuario;
}

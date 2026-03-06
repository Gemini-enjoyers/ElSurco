package com.elSurco.ElSurco_in5bv.dto;
import com.elSurco.ElSurco_in5bv.Util.Rol;

public class LoginResponse {
    public String message;
    public Integer idLogin;
    public String email;
    public Rol rolUsuario;

    public LoginResponse(String message, Integer idLogin, String email, Rol rolUsuario) {
        this.message = message;
        this.idLogin = idLogin;
        this.email = email;
        this.rolUsuario = rolUsuario;
    }
}

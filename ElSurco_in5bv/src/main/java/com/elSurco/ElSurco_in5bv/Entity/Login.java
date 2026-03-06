package com.elSurco.ElSurco_in5bv.Entity;

import com.elSurco.ElSurco_in5bv.Util.Rol;
import jakarta.persistence.*;

@Entity
@Table(name = "Login")
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idLogin")
    private Integer idLogin;

    @Column(name = "emailLogin", unique = true, nullable = false, length = 100)
    private String emailLogin;

    @Column(name = "passwordLogin", nullable = false)
    private String passwordLogin;

    @Enumerated(EnumType.STRING)
    @Column(name = "rolUsuario", nullable = false)
    private Rol rolUsuario;

    public Login() {
    }

    public Login(String emailLogin, String passwordLogin, Rol rolUsuario) {
        this.emailLogin = emailLogin;
        this.passwordLogin = passwordLogin;
        this.rolUsuario = rolUsuario;
    }

    public Integer getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(Integer idLogin) {
        this.idLogin = idLogin;
    }

    public String getEmailLogin() {
        return emailLogin;
    }

    public void setEmailLogin(String emailLogin) {
        this.emailLogin = emailLogin;
    }

    public String getPasswordLogin() {
        return passwordLogin;
    }

    public void setPasswordLogin(String passwordLogin) {
        this.passwordLogin = passwordLogin;
    }

    public Rol getRolUsuario() {
        return rolUsuario;
    }

    public void setRolUsuario(Rol rolUsuario) {
        this.rolUsuario = rolUsuario;
    }
}
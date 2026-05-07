package com.elSurco.ElSurco_in5bv.Entity;

import com.elSurco.ElSurco_in5bv.Util.Role;
import jakarta.persistence.*;

@Entity
@Table(name = "Login")
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idLogin")
    private Integer idLogin;

    @Column(name = "loginEmail", unique = true, nullable = false, length = 100)
    private String loginEmail;

    @Column(name = "loginPassword", nullable = false)
    private String loginPassword;

    @Enumerated(EnumType.STRING)
    @Column(name = "userRole", nullable = false)
    private Role userRole;

    public Login() {}
    public Login(String loginEmail, String loginPassword, Role userRole) {
        this.loginEmail = loginEmail;
        this.loginPassword = loginPassword;
        this.userRole = userRole;
    }

    public Integer getIdLogin() { return idLogin; }
    public void setIdLogin(Integer idLogin) { this.idLogin = idLogin; }
    public String getLoginEmail() { return loginEmail; }
    public void setLoginEmail(String loginEmail) { this.loginEmail = loginEmail; }
    public String getLoginPassword() { return loginPassword; }
    public void setLoginPassword(String loginPassword) { this.loginPassword = loginPassword; }
    public Role getUserRole() { return userRole; }
    public void setUserRole(Role userRole) { this.userRole = userRole; }
}
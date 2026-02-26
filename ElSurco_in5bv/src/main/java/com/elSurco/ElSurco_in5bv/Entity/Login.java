package com.elSurco.ElSurco_in5bv.Entity;

import com.elSurco.ElSurco_in5bv.Util.Rol;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "Login")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLogin;

    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "Debe ingresar un formato de correo válido")
    @Column(unique = true, nullable = false, length = 100)
    private String emailLogin;

    @NotBlank(message = "La contraseña es obligatoria")
    @Column(nullable = false)
    private String passwordLogin;

    @NotNull(message = "El rol de usuario es obligatorio")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Rol rolUsuario;
}
package com.elSurco.ElSurco_in5bv.Entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table (name =  "Comprador")
public class Comprador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idComprador")
    private Integer idComprador;

    @NotBlank(message = "El nombre de categoria es obligatorio.")
    @Size(min = 2, max = 100, message = "El nombre debe tener 2 a 100 carractere.")
    @Column(name = "nombreComprador")
    private String nombreComprador;

    @NotBlank(message = "El apellido es obligatorio.")
    @Size(min = 2, max = 100, message = "El apellido es obligatorio.")
    @Column(name = "apellidoComprador")
    private String apellidoComprador;

    @NotNull(message = "El numero de telefono no puede estar vacio.")
    @Min(value = 10000000, message = "El numero de telefono no es valido")
    @Max(value = 99999999, message = "El numero de telefono no puede ser mas de 8 digitos.")
    @Column(name = "telefonoComprador")
    private Long telefonoComprador;

    @NotBlank(message = "La dirreccion tiene que ser obligatorio.")
    @Size(max = 255, message = "La direccion es demaciado larga.")
    @Column(name = "direccionComprador")
    private String direccionComprador;

    @Column(name = "idLogin", nullable = false)
    private Integer idLogin;

    public Integer getIdLogin() {
        return idLogin;
    }
    public void setIdLogin(Integer idLogin) {
        this.idLogin = idLogin;
    }

    public Integer getIdComprador() {
        return idComprador;
    }

    public void setIdComprador(Integer idComprador) {
        this.idComprador = idComprador;
    }

    public String getNombreComprador() {
        return nombreComprador;
    }

    public void setNombreComprador(String nombreComprador) {
        this.nombreComprador = nombreComprador;
    }

    public String getApellidoComprador() {
        return apellidoComprador;
    }

    public void setApellidoComprador(String apellidoComprador) {
        this.apellidoComprador = apellidoComprador;
    }

    public Long getTelefonoComprador() {
        return telefonoComprador;
    }

    public void setTelefonoComprador(Long telefonoComprador) {
        this.telefonoComprador = telefonoComprador;
    }

    public String getDireccionComprador() {
        return direccionComprador;
    }

    public void setDireccionComprador(String direccionComprador) {
        this.direccionComprador = direccionComprador;
    }
}
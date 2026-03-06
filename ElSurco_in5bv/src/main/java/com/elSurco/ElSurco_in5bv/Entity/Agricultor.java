package com.elSurco.ElSurco_in5bv.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "Agricultor")
public class Agricultor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAgricultor")
    private Integer idAgricultor;

    @NotBlank(message = "El nombre es obligatorio.")
    @Size(min = 2, max = 100, message = "El nombre debe tener 2 a 100 carractere.")
    @Column(name = "nombreAgricultor")
    private String nombreAgricultor;

    @NotBlank(message = "El apellido es obligatorio.")
    @Size(min = 2, max = 100, message = "El apellido es obligatorio.")
    @Column(name = "apellidoAgricultor")
    private String apellidoAgricultor;

    @NotBlank(message = "El DPI es obligatorio.")
    @Pattern(regexp = "//d{13}", message = "El DPI tiene que tener 13 numeros.")
    @Column(name = "dpiAgricultor")
    private String dpiAgricultor;

    @NotBlank(message = "El numero de telefono no puede estar vacio.")
    @Min(value = 10000000, message = "El numero de telefono no es valido")
    @Max(value = 99999999, message = "El numero de telefono no puede ser mas de 8 digitos.")
    @Column(name = "telefonoAgricultor")
    private Long telefonoAgricultor;

    @NotBlank(message = "La dirreccion tiene que ser obligatorio.")
    @Size(max = 255, message = "La direccion es demaciado larga.")
    @Column(name = "direccionAgricultor")
    private String direccionAgricultor;

    @Pattern(regexp = "^[-+]?([1-8]?\\d(\\.\\d+)?|90(\\.0+)?),\\s*[-+]?(180(\\.0+)?|((1[0-7]\\d)|([1-9]?\\d))(\\.\\d+)?)$", message = "El formato GPS debe ser coordenadas válidas (Latitud, Longitud).")
    @Column(name = "gpsAgricultor")
    private String gpsAgricultor;

    @Size(max = 100, message = "La historia no debe sde seperar los 100 caracteres.")
    @Column(name = "historiaAgricultor")
    private String historiaAgricultor;

    @Column(name = "idLogin")
    private Integer idLogin;

    public int getIdAgricultor() {
        return idAgricultor;
    }

    public void setIdAgricultor(Integer idAgricultor) {
        this.idAgricultor = idAgricultor;
    }

    public String getNombres() {
        return nombreAgricultor;
    }

    public void setNombres(String nombreAgricultor) {
        this.nombreAgricultor = nombreAgricultor;
    }

    public String getApellidos() {return apellidoAgricultor;
    }

    public void setApellidos(String apellidoAgricultor) {
        this.apellidoAgricultor = apellidoAgricultor;
    }

    public String getDpi() {
        return dpiAgricultor;
    }

    public void setDpi(String dpiAgricultor) {
        this.dpiAgricultor = dpiAgricultor;
    }

    public Long getTelefono() {
        return telefonoAgricultor;
    }

    public void setTelefono(Long telefonoAgricultor) {
           this.telefonoAgricultor = telefonoAgricultor;
    }

    public String getComunidadAldea() {
        return direccionAgricultor;
    }

    public void setComunidadAldea(String direccionAgricultor) {
        this.direccionAgricultor = direccionAgricultor;
    }

    public String getCoordenadasGps() {
        return gpsAgricultor;
    }

    public void setCoordenadasGps(String gpsAgricultor) {
        this.gpsAgricultor = gpsAgricultor;
    }

    public String getHistoriaPerfil() {
        return historiaAgricultor;
    }

    public void setHistoriaPerfil(String historiaAgricultor) {
        this.historiaAgricultor = historiaAgricultor;
    }

    public int getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(int idLogin) {
        this.idLogin = idLogin;
    }
}

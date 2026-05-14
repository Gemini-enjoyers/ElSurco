package com.elSurco.ElSurco_in5bv.Entity;

import com.elSurco.ElSurco_in5bv.Util.Status;
import jakarta.persistence.*;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUser")
    private Integer idUser;

    // --- CAMPOS NUEVOS QUE FALTABAN DE TU SQL ---
    @Column(name = "userFirstName") // Ojo: pon "userFirtName" si no lo corregiste en la base de datos
    private String userFirstName;

    @Column(name = "userLastName")
    private String userLastName;

    @Column(name = "handle")
    private String handle;
    // ---------------------------------------------

    @Column(name = "userEmail")
    private String Uemail;

    @Column(name = "userPassword")
    private String Upassword;

    @Column(name = "userAddress")
    private String Uadress;

    @Column(name = "userPhone")
    private Long Uphone; // Cambiado a Long porque en tu SQL es bigint

    @Enumerated(EnumType.STRING)
    @Column(name = "userStatus")
    private Status uStatus = Status.ACTIVE;

    // 1. CONSTRUCTOR VACÍO (Obligatorio para Spring Boot/Hibernate)
    public User() {
    }

    // 2. CONSTRUCTOR CON PARÁMETROS (Actualizado con los nuevos campos)
    public User(Integer idUser, String userFirstName, String userLastName, String handle, String uemail, String upassword, String uadress, Long uphone, Status uStatus) {
        this.idUser = idUser;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.handle = handle;
        this.Uemail = uemail;
        this.Upassword = upassword;
        this.Uadress = uadress;
        this.Uphone = uphone;
        this.uStatus = uStatus;
    }

    // --- GETTERS Y SETTERS ---

    public Integer getIdUser() { return idUser; }
    public void setIdUser(Integer idUser) { this.idUser = idUser; }

    public String getUserFirstName() { return userFirstName; }
    public void setUserFirstName(String userFirstName) { this.userFirstName = userFirstName; }

    public String getUserLastName() { return userLastName; }
    public void setUserLastName(String userLastName) { this.userLastName = userLastName; }

    public String getHandle() { return handle; }
    public void setHandle(String handle) { this.handle = handle; }

    public String getUemail() { return Uemail; }
    public void setUemail(String uemail) { Uemail = uemail; }

    public String getUpassword() { return Upassword; }
    public void setUpassword(String upassword) { Upassword = upassword; }

    public String getUadress() { return Uadress; }
    public void setUadress(String uadress) { Uadress = uadress; }

    public Long getUphone() { return Uphone; }
    public void setUphone(Long uphone) { Uphone = uphone; }

    public Status getuStatus() { return uStatus; }
    public void setuStatus(Status uStatus) { this.uStatus = uStatus; }
}
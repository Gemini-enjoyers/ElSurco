package com.elSurco.ElSurco_in5bv.Entity;

import com.elSurco.ElSurco_in5bv.Util.Status;
import jakarta.persistence.*;

@Entity
@Table (name =  "Users")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUser")
    private Integer idUser;

    @Column(name = "userEmail")
    private String Uemail;

    @Column(name = "userPassword")
    private String Upassword;

    @Column(name = "userAddress")
    private String Uadress;

    @Column(name = "userPhone")
    private String Uphone;



    @Enumerated(EnumType.STRING) // Importante: Guarda el texto (ACTIVE)
    @Column(name = "userStatus")
    private Status uStatus = Status.ACTIVE;

    public User(Integer idUser, String uemail, String upassword, String uadress, String uphone, Status uStatus) {
        this.idUser = idUser;
        Uemail = uemail;
        Upassword = upassword;
        Uadress = uadress;
        Uphone = uphone;
        this.uStatus = uStatus;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getUemail() {
        return Uemail;
    }

    public void setUemail(String uemail) {
        Uemail = uemail;
    }

    public String getUpassword() {
        return Upassword;
    }

    public void setUpassword(String upassword) {
        Upassword = upassword;
    }

    public String getUadress() {
        return Uadress;
    }

    public void setUadress(String uadress) {
        Uadress = uadress;
    }

    public String getUphone() {
        return Uphone;
    }

    public void setUphone(String uphone) {
        Uphone = uphone;
    }

    public Status getuStatus() {
        return uStatus;
    }

    public void setuStatus(Status uStatus) {
        this.uStatus = uStatus;
    }
}
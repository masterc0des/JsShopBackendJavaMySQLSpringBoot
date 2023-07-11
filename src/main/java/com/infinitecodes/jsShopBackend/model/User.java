package com.infinitecodes.jsShopBackend.model;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblUser")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="U_ID")
    private Integer ID;

    @Column(name="U_Vorname")
    private String vorname;

    @Column(name="U_Nachname")
    private String nachname;

    @Column(name="U_Geburtsdatum")
    private String geburtsdatum;

    @Column(name="U_Adresse")
    private String adresse;

    @Column(name="U_Hausnummer")
    private Integer hausnummer;

    @Column(name="U_PLZ")
    private Integer plz;

    @Column(name="U_Ort")
    private String ort;

    @Column(name="U_Email")
    private String email;

    @Column(name="U_Nutzername")
    private String nutzername;

    @Column(name="U_Passwort")
    private String passwort;

    // Get Attributes
    public Integer getU_ID() {
        return ID;
    }

    public String getU_Vorname() {
        return vorname;
    }

    public String getU_Nachname() {
        return nachname;
    }

    public String getU_Geburtsdatum() {
        return geburtsdatum;
    }

    public String getU_Adresse() {
        return adresse;
    }

    public Integer getU_PLZ() {
        return plz;
    }

    public String getU_Ort() {
        return ort;
    }

    public String getU_Email() {
        return email;
    }

    public String getU_Nutzername() {
        return nutzername;
    }

    public String getU_Passwort() {
        return passwort;
    }

    // Set Attributes
    public void setU_Vorname(String vorname) {
        this.vorname = vorname;
    }

    public void setU_Nachname(String nachname) {
        this.nachname = nachname;
    }

    public void setU_Geburtsdatum(String geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
    }

    public void setU_Adresse(String adresse) {
        this.adresse = adresse;
    }

    public void setU_Hausnummer(Integer hausnummer) {
        this.hausnummer = hausnummer;
    }

    public void setU_PLZ(Integer plz) {
        this.plz = plz;
    }

    public void setU_Ort(String ort) {
        this.ort = ort;
    }

    public void setU_Email(String u_Email) {
        email = u_Email;
    }

    public void setU_Nutzername(String u_Nutzername) {
        nutzername = u_Nutzername;
    }

    public void setU_Passwort(String u_Passwort) {
        passwort = u_Passwort;
    }
}

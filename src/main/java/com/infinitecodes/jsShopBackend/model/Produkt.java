package com.infinitecodes.jsShopBackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblProdukt")
public class Produkt {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="P_ID")
    private Integer ID;

    @Column(name="P_Artikelnummer")
    private Integer artikelnummer;

    @Column(name="P_Produktname")
    private String produktname;

    @Column(name="P_Produktpreis")
    private float produktpreis;

    @Column(name="P_Hersteller")
    private String hersteller;

    @Column(name="P_Bild")
    private String bild;

    // Get Attributes
    public Integer getP_ID() {
        return ID;
    }

    public Integer getP_Artikelnummer() {
        return artikelnummer;
    }

    public String getP_Produktname() {
        return produktname;
    }

    public float getP_Produktpreis() {
        return produktpreis;
    }

    public String getP_Hersteller() {
        return hersteller;
    }

    public String getP_Bild() {
        return bild;
    }

    // Set attributes
    public void setP_Artikelnummer(Integer artikelnummer) {
        this.artikelnummer = artikelnummer;
    }

    public void setP_Produktname(String produktname) {
        this.produktname = produktname;
    }

    public void setP_Produktpreis(float produktpreis) {
        this.produktpreis = produktpreis;
    }

    public void setP_Hersteller(String hersteller) {
        this.hersteller = hersteller;
    }

    public void setP_Bild(String bildpfad) {
        this.bild = bildpfad;
    }
}

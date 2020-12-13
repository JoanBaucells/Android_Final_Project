package com.uvic.jbaucellsssales.Entitats;

public class Competidor {
    private String nom;
    private String cognom;
    private String numero_telefon;
    private String email;
    private int idCompetidor;

    public Competidor(int idCompetidor) {
        this.idCompetidor = idCompetidor;
    }

    public Competidor(String nom, String cognom, String numero_telefon, String email, int idCompetidor) {
        this.nom = nom;
        this.cognom = cognom;
        this.numero_telefon = numero_telefon;
        this.email = email;
        this.idCompetidor = idCompetidor;
    }

    public int getIdCompetidor(){ return this.idCompetidor; }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom() {
        return cognom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public String getNumero_telefon() {
        return numero_telefon;
    }

    public void setNumero_telefon(String numero_telefon) {
        this.numero_telefon = numero_telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Competidor{" +
                "nom='" + nom + '\'' +
                ", cognom='" + cognom + '\'' +
                ", numero_telefon='" + numero_telefon + '\'' +
                ", email='" + email + '\'' +
                ", idCompetidor=" + idCompetidor +
                '}';
    }
}

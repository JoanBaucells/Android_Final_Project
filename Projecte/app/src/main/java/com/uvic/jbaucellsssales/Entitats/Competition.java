package com.uvic.jbaucellsssales.Entitats;

public class Competition {
    private int idCompetition;
    private String Name;
    private String Description;
    private float Price;
    private String Poblacio;
    private String Data;
    private int maxInscrits;

    public Competition(int idCompetition,  String name, String description, float price, String poblacio, String data, int maxInscrits) {
        this.idCompetition = idCompetition;
        Name = name;
        Description = description;
        Price = price;
        Poblacio = poblacio;
        Data = data;
        this.maxInscrits = maxInscrits;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getIdCompetition() {
        return idCompetition;
    }

    public void setIdCompetition(int idCompetition) {
        this.idCompetition = idCompetition;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        Price = price;
    }

    public String getPoblacio() {
        return Poblacio;
    }

    public void setPoblacio(String poblacio) {
        Poblacio = poblacio;
    }

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }

    public int getMaxInscrits() {
        return maxInscrits;
    }

    public void setMaxInscrits(int maxInscrits) {
        this.maxInscrits = maxInscrits;
    }
}

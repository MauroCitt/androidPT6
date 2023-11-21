package com.example.pt6httpmauro.Models;

public class Liga {
    private String nombreEquipo;
    private String abreviacionEquipo;
    private String idEquipo;

    public Liga(String nombreEquipo, String abreviacionEquipo, String imagenEquipo) {
        this.nombreEquipo = nombreEquipo;
        this.abreviacionEquipo = abreviacionEquipo;
        this.idEquipo = imagenEquipo;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public String getAbreviacionEquipo() {
        return abreviacionEquipo;
    }

    public void setAbreviacionEquipo(String abreviacionEquipo) {
        this.abreviacionEquipo = abreviacionEquipo;
    }

    public String getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(String idEquipo) {
        this.idEquipo = idEquipo;
    }
}

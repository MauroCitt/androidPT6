package com.example.pt6httpmauro.Models;

public class Liga {
    private String nombreEquipo;
    private String abreviacionEquipo;

    public Liga(String nombreEquipo, String abreviacionEquipo ) {
        this.nombreEquipo = nombreEquipo;
        this.abreviacionEquipo = abreviacionEquipo;
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
}

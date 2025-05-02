package com.restaurant.domain.model;

public class Bebida implements MenuItem {
    private String nombre;
    private double precio;

    public Bebida(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public double getPrecio() {
        return precio;
    }
}

package com.restaurant.domain.model;

public class Bebida implements MenuItem {
    private String nombre;
    private double precio;
    private String descripcion;

    public Bebida(String nombre, double precio, String descripcion) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public double getPrecio() {
        return precio;
    }

    @Override
    public String getDescripcion() {
        return descripcion;
    }
}

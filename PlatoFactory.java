package com.restaurant.infrastructure.factory;

import com.restaurant.domain.model.*;

public class PlatoFactory implements MenuItemFactory {
    private String nombre;
    private double precio;
    private String descripcion;

    public PlatoFactory(String nombre, double precio, String descripcion) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    @Override
    public MenuItem crearItem() {
        return new PlatoPrincipal(nombre, precio, descripcion);
    }
}

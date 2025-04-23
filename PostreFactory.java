package com.restaurant.infrastructure.persistence;

import com.restaurant.domain.model.Postre;
import com.restaurant.domain.model.MenuItem;

public class PostreFactory implements MenuItemFactory {
    private String nombre;
    private double precio;
    private String descripcion;

    public PostreFactory(String nombre, double precio, String descripcion) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    @Override
    public MenuItem crearItem() {
        return new Postre(nombre, precio, descripcion);
    }
}

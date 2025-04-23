package com.restaurant.infrastructure.persistence;

import com.restaurant.domain.model.Bebida;
import com.restaurant.domain.model.MenuItem;

public class BebidaFactory implements MenuItemFactory {
    private String nombre;
    private double precio;
    private String descripcion;

    public BebidaFactory(String nombre, double precio, String descripcion) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    @Override
    public MenuItem crearItem() {
        return new Bebida(nombre, precio, descripcion);
    }
}

package com.restaurant.domain.factory;

import com.restaurant.domain.model.MenuItem;
import com.restaurant.domain.model.Postre;

public class PostreFactory implements MenuItemFactory {

    @Override
    public MenuItem crear(String nombre, double precio) {
        return new Postre(nombre, precio);
    }
}

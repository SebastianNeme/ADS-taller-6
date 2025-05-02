package com.restaurant.domain.factory;

import com.restaurant.domain.model.MenuItem;
import com.restaurant.domain.model.PlatoPrincipal;

public class PlatoFactory implements MenuItemFactory {

    @Override
    public MenuItem crear(String nombre, double precio) {
        return new PlatoPrincipal(nombre, precio);
    }
}

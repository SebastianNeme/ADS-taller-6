package com.restaurant.application;

import com.restaurant.domain.model.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MenuService {
    private List<MenuItem> menu;

    public MenuService() {
        this.menu = new ArrayList<>();
    }

    public void agregarItem(MenuItem item) {
        menu.add(item);
    }

    public List<MenuItem> obtenerMenu() {
        return menu;
    }

    public void mostrarMenu() {
        System.out.println("===== MENÚ DEL RESTAURANTE =====");
        for (MenuItem item : menu) {
            System.out.println("- " + item.getNombre() + " | $" + item.getPrecio() + " | " + item.getDescripcion());
        }
    }
}


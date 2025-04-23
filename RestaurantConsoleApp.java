package com.restaurant.ui;

import com.restaurant.application.MenuService;
import com.restaurant.infrastructure.factory.*;
import com.restaurant.domain.model.MenuItem;

public class RestaurantConsoleApp {
    public static void main(String[] args) {
        MenuService menuService = new MenuService();

        MenuItemFactory platoFactory = new PlatoFactory("Hamburguesa Clásica", 15000, "Con papas a la francesa");
        MenuItemFactory bebidaFactory = new BebidaFactory("Jugo Natural", 5000, "Jugo de mango sin azúcar");
        MenuItemFactory postreFactory = new PostreFactory("Flan de coco", 7000, "Hecho en casa");

        menuService.agregarItem(platoFactory.crearItem());
        menuService.agregarItem(bebidaFactory.crearItem());
        menuService.agregarItem(postreFactory.crearItem());

        menuService.mostrarMenu();
    }
}


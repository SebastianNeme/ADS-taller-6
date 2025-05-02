package com.restaurant.application;

import com.restaurant.domain.model.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MenuService {

    private List<MenuItem> menu = new ArrayList<>();

    /**
     * Agrega un nuevo ítem al menú.
     */
    public void agregarItem(MenuItem item) {
        menu.add(item);
    }

    /**
     * Devuelve todos los ítems del menú.
     */
    public List<MenuItem> obtenerMenu() {
        return new ArrayList<>(menu); // retorna copia para evitar modificación externa
    }

    /**
     * Imprime el menú por consola.
     */
    public void mostrarMenu() {
        System.out.println("\n--- MENÚ DEL RESTAURANTE ---");
        for (int i = 0; i < menu.size(); i++) {
            MenuItem item = menu.get(i);
            System.out.printf("%d. %s - $%.2f%n", i + 1, item.getNombre(), item.getPrecio());
        }
    }

    /**
     * Devuelve un ítem del menú según su índice (comenzando en 0).
     */
    public MenuItem obtenerItemPorIndice(int indice) {
        if (indice >= 0 && indice < menu.size()) {
            return menu.get(indice);
        }
        return null;
    }

    /**
     * Limpia todos los ítems del menú (útil para pruebas o reinicio).
     */
    public void limpiarMenu() {
        menu.clear();
    }
}

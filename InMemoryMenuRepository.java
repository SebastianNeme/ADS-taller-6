
package com.restaurant.infrastructure;

import com.restaurant.domain.model.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class InMemoryMenuRepository {

    private List<MenuItem> items = new ArrayList<>();

    public void guardar(MenuItem item) {
        items.add(item);
    }

    public List<MenuItem> obtenerTodos() {
        return new ArrayList<>(items); // retornamos una copia
    }

    public MenuItem obtenerPorIndice(int index) {
        if (index >= 0 && index < items.size()) {
            return items.get(index);
        }
        return null;
    }

    public void limpiar() {
        items.clear();
    }
}

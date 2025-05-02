package com.restaurant.infrastructure;

import com.restaurant.domain.model.Order;

import java.util.ArrayList;
import java.util.List;

public class InMemoryOrderRepository {

    private List<Order> pedidos = new ArrayList<>();

    public void guardar(Order pedido) {
        pedidos.add(pedido);
    }

    public List<Order> obtenerTodos() {
        return pedidos;
    }

    public Order buscarPorId(int id) {
        for (Order p : pedidos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public void limpiar() {
        pedidos.clear();
    }
}



package com.restaurant.application;

import com.restaurant.domain.model.Customer;
import com.restaurant.domain.model.MenuItem;
import com.restaurant.domain.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderService {

    private List<Order> pedidos = new ArrayList<>();
    private int idSecuencial = 1;

    /**
      Crea un nuevo pedido y lo agrega a la lista de pedidos registrados.
      @param items Lista de ítems del menú seleccionados
      @param cliente Cliente que hace el pedido
      @return el pedido creado
     */
    public Order crearPedido(List<MenuItem> items, Customer cliente) {
        Order pedido = new Order(idSecuencial++, cliente);
        for (MenuItem item : items) {
            pedido.agregarItem(item);
        }
        pedidos.add(pedido);
        return pedido;
    }

    /**
     * Devuelve todos los pedidos realizados.
     */
    public List<Order> obtenerTodosLosPedidos() {
        return pedidos;
    }

    /**
     * Avanza el estado de un pedido con base en su ID.
     * Si el pedido no existe, muestra un mensaje de error.
     */
    public void avanzarEstadoPedido(int idPedido) {
        for (Order p : pedidos) {
            if (p.getId() == idPedido) {
                p.avanzarEstado();
                return;
            }
        }
        System.out.println(" Pedido con ID " + idPedido + " no encontrado.");
    }
}

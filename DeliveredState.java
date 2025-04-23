package com.restaurant.domain.state;

import com.restaurant.domain.model.Order;

public class DeliveredState implements OrderState {

    @Override
    public void avanzarEstado(Order order) {
        System.out.println("El pedido ya fue entregado. No puede avanzar más.");
    }

    @Override
    public String getNombreEstado() {
        return "Entregado";
    }
}
 

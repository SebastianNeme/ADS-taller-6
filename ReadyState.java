package com.restaurant.domain.state;

import com.restaurant.domain.model.Order;

public class ReadyState implements OrderState {

    @Override
    public void avanzarEstado(Order order) {
        order.setEstado(new DeliveredState());
    }

    @Override
    public String getNombreEstado() {
        return "Listo para entregar";
    }
}

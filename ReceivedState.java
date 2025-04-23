package com.restaurant.domain.state;

import com.restaurant.domain.model.Order;

public class ReceivedState implements OrderState {

    @Override
    public void avanzarEstado(Order order) {
        order.setEstado(new PreparingState());
    }

    @Override
    public String getNombreEstado() {
        return "Recibido";
    }
}

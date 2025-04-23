package com.restaurant.domain.state;

import com.restaurant.domain.model.Order;

public class PreparingState implements OrderState {

    @Override
    public void avanzarEstado(Order order) {
        order.setEstado(new ReadyState());
    }

    @Override
    public String getNombreEstado() {
        return "En Preparación";
    }
}

package com.restaurant.domain.state;

import com.restaurant.domain.model.Order;

public interface OrderState {
    void avanzarEstado(Order order);
    String getNombreEstado();
}

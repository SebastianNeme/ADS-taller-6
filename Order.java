package com.restaurant.domain.model;

import com.restaurant.domain.state.OrderState;
import com.restaurant.domain.state.ReceivedState;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String id;
    private Customer cliente;
    private List<MenuItem> items;
    private OrderState estado;

    public Order(String id, Customer cliente) {
        this.id = id;
        this.cliente = cliente;
        this.items = new ArrayList<>();
        this.estado = new ReceivedState(); // Estado inicial
    }

    public String getId() {
        return id;
    }

    public Customer getCliente() {
        return cliente;
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public void agregarItem(MenuItem item) {
        items.add(item);
    }

    public double calcularTotal() {
        double total = 0;
        for (MenuItem item : items) {
            total += item.getPrecio();
        }
        return total;
    }

    public OrderState getEstado() {
        return estado;
    }

    public void setEstado(OrderState estado) {
        this.estado = estado;
    }

    public void avanzarEstado() {
        estado.avanzarEstado(this);
    }

    public String getNombreEstado() {
        return estado.getNombreEstado();
    }

    public void mostrarResumen() {
        System.out.println("Pedido ID: " + id);
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Estado: " + getNombreEstado());
        System.out.println("Items:");
        for (MenuItem item : items) {
            System.out.println("- " + item.getNombre() + " | $" + item.getPrecio() + " | " + item.getDescripcion());
        }
        System.out.println("Total: $" + calcularTotal());
    }
}


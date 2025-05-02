package com.restaurant.application;

import com.restaurant.domain.model.Order;
import com.restaurant.domain.model.MenuItem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportService {

    public void mostrarPedidos(List<Order> pedidos) {
        System.out.println("LISTADO DE PEDIDOS:");
        for (Order pedido : pedidos) {
            System.out.println("Pedido #" + pedido.getId() + " - Estado: " + pedido.getNombreEstado());
            for (MenuItem item : pedido.getItems()) {
                System.out.println("  - " + item.getNombre() + ": $" + item.getPrecio());
            }
            double total = pedido.getItems().stream().mapToDouble(MenuItem::getPrecio).sum();
            System.out.println("  Total: $" + total);
            System.out.println();
        }
    }

    public void mostrarTotalVentas(List<Order> pedidos) {
        double total = 0;
        for (Order pedido : pedidos) {
            total += pedido.getItems().stream().mapToDouble(MenuItem::getPrecio).sum();
        }
        System.out.println("TOTAL DE VENTAS: $" + total);
    }

    public void mostrarPlatosMasVendidos(List<Order> pedidos) {
        Map<String, Integer> contador = new HashMap<>();

        for (Order pedido : pedidos) {
            for (MenuItem item : pedido.getItems()) {
                contador.put(item.getNombre(), contador.getOrDefault(item.getNombre(), 0) + 1);
            }
        }

        System.out.println(" PLATOS MAS VENDIDOS:");
        contador.entrySet().stream()
                .sorted((a, b) -> b.getValue() - a.getValue())
                .forEach(e -> System.out.println(e.getKey() + " - " + e.getValue() + " vendidos"));
    }
}

package com.restaurant.application;

import com.restaurant.domain.model.Order;
import com.restaurant.domain.model.MenuItem;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class ReportService {

    public void mostrarPedidos(List<Order> pedidos) {
        System.out.println("=== Reporte de Pedidos Realizados ===");
        for (Order pedido : pedidos) {
            pedido.mostrarResumen();
            System.out.println("-----------------------------");
        }
    }

    public void mostrarTotalVentas(List<Order> pedidos) {
        double total = 0;
        for (Order pedido : pedidos) {
            total += pedido.calcularTotal();
        }
        System.out.println("Total de ventas: $" + total);
    }

    public void mostrarPlatosMasVendidos(List<Order> pedidos) {
        Map<String, Integer> conteo = new HashMap<>();

        for (Order pedido : pedidos) {
            for (MenuItem item : pedido.getItems()) {
                conteo.put(item.getNombre(), conteo.getOrDefault(item.getNombre(), 0) + 1);
            }
        }

        System.out.println("=== Platos más vendidos ===");
        conteo.entrySet()
              .stream()
              .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
              .forEach(entry ->
                  System.out.println(entry.getKey() + ": " + entry.getValue() + " unidades")
              );
    }
}


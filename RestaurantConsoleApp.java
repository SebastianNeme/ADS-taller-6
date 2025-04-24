package com.restaurant.ui;

import com.restaurant.domain.model.*;
import com.restaurant.infrastructure.persistence.*;
import com.restaurant.application.*;
import java.util.*;

public class RestaurantConsoleApp {

    private static MenuService menuService = new MenuService();
    private static List<Order> pedidos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static ReportService reportService = new ReportService();

    public static void main(String[] args) {
        inicializarMenu();

        boolean salir = false;
        while (!salir) {
            mostrarMenu();
            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    menuService.mostrarMenu();
                    break;
                case 2:
                    crearPedido();
                    break;
                case 3:
                    verPedidos();
                    break;
                case 4:
                    avanzarEstadoPedido();
                    break;
                case 5:
                    reportService.mostrarTotalVentas(pedidos);
                    break;
                case 6:
                    reportService.mostrarPlatosMasVendidos(pedidos);
                    break;
                case 7:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n=== Menú Principal ===");
        System.out.println("1. Ver menú");
        System.out.println("2. Crear pedido");
        System.out.println("3. Ver pedidos");
        System.out.println("4. Avanzar estado de un pedido");
        System.out.println("5. Ver total de ventas");
        System.out.println("6. Ver platos más vendidos");
        System.out.println("7. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void inicializarMenu() {
        menuService.agregarItem(new PlatoFactory("Hamburguesa", 15000, "Clásica con papas").crearItem());
        menuService.agregarItem(new BebidaFactory("Gaseosa", 4000, "350 ml").crearItem());
        menuService.agregarItem(new PostreFactory("Helado", 7000, "Vainilla").crearItem());
    }

    private static void crearPedido() {
        System.out.print("Ingrese ID del pedido: ");
        String id = scanner.nextLine();

        System.out.print("Nombre del cliente: ");
        String nombre = scanner.nextLine();
        Customer cliente = new Customer(nombre);

        Order pedido = new Order(id, cliente);
        menuService.mostrarMenu();

        System.out.println("Ingrese el nombre del ítem que desea agregar (ENTER para terminar):");
        while (true) {
            String itemNombre = scanner.nextLine();
            if (itemNombre.isBlank()) break;

            Optional<MenuItem> encontrado = menuService.obtenerMenu().stream()
                .filter(i -> i.getNombre().equalsIgnoreCase(itemNombre))
                .findFirst();

            if (encontrado.isPresent()) {
                pedido.agregarItem(encontrado.get());
            } else {
                System.out.println("Ítem no encontrado.");
            }
        }

        pedidos.add(pedido);
        System.out.println("Pedido creado exitosamente.");
    }

    private static void verPedidos() {
        for (Order pedido : pedidos) {
            pedido.mostrarResumen();
            System.out.println("----------------------------");
        }
    }

    private static void avanzarEstadoPedido() {
        System.out.print("Ingrese ID del pedido a actualizar: ");
        String id = scanner.nextLine();

        for (Order pedido : pedidos) {
            if (pedido.getId().equals(id)) {
                System.out.println("Estado actual: " + pedido.getNombreEstado());
                pedido.avanzarEstado();
                System.out.println("Nuevo estado: " + pedido.getNombreEstado());
                return;
            }
        }

        System.out.println("Pedido no encontrado.");
    }
}

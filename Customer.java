
package com.restaurant.domain.model;

public class Customer {
    private String nombre;
    private String contacto;

    public Customer(String nombre, String contacto) {
        this.nombre = nombre;
        this.contacto = contacto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContacto() {
        return contacto;
    }
}

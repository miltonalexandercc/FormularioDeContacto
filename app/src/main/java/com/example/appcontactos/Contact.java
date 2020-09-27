package com.example.appcontactos;

import java.io.Serializable;

public class Contact implements Serializable {
    private String nombre;
    private String fecha;
    private String email;
    private String telefono;
    private String descripcion;

    public Contact(String nombre, String fecha, String email, String telefono, String descripcion) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.email = email;
        this.telefono = telefono;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Contact { " +
                "nombre='" + nombre + '\'' +
                ", fecha='" + fecha + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}

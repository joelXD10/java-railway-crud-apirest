package com.joelreinoso.apirest.apirest.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Producto {

    ///Anotacion que marcar un campo de una clase como la clave primaria de la entidad.
    @Id
    ////Anotacion que se utiliza para especificar que el valor de la clave primaria se generará de manera automática.
    @GeneratedValue(strategy = GenerationType.IDENTITY)  ///es una estrategia de generación de valores que indica que la base de datos será la responsable de generar el valor de la clave primaria, autoincremental.
    private Long Id;
    private String nombre;
    private Double precio;

    public Long getId() {
        return Id;
    }
    public void setId(Long id) {
        Id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Double getPrecio() {
        return precio;
    }
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
   
    
}

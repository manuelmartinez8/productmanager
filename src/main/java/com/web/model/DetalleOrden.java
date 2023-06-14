package com.web.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.OneToOne;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DetalleOrden {

    private long id;

    private String nombre;
    private double cantidad;
    private double precio;
    private double total;
    private Orden orden;
    private Product producto;
}

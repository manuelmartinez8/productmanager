package com.web.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Orden {

    private long id;
    private String numero;
    private Date fechaCreacion;
    private Date fechaRecibida;
    private double total;
    private DetalleOrden detalle;
    private User user;




}

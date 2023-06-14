package org.web.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "detalles")
public class EDetalleOrden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private double cantidad;
    private double precio;
    private double total;
    @OneToOne
    private EOrden orden;
    @OneToOne
    private EProduct producto;

}

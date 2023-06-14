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
@Table(name = "ordenes")
public class EOrden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String numero;
    private Date fechaCreacion;
    private Date fechaRecibida;

    private double total;
    @ManyToOne
    private EUser usuario;
    @OneToOne(mappedBy = "orden")
    private EDetalleOrden detalle;


}

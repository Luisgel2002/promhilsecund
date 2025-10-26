package com.proyectoSecundario.proyect_secund.model;

import java.time.LocalDate;


import org.hibernate.annotations.DynamicInsert;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "detalle_venta")
@DynamicInsert
@Getter @Setter
public class DetalleVentas {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle")
    private Integer idDetalle;

    @ManyToOne
    @JoinColumn(name = "id_venta")
    private Ventas venta;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Productos producto;

    
    @Column(name = "cantidad")
    private Integer cantidad;

  
    @Column(name = "subtotal")
    private Double subtotal;

}

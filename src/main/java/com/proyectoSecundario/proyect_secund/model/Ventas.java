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
@Table(name = "ventas")
@DynamicInsert
@Getter @Setter
public class Ventas {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id_venta")
	    private Integer idVenta;

	  
	    @Column(name = "fecha")
	    private LocalDate fecha;
	    
	    
	    @Column(name = "total")
	    private Double total;

	  
	    @ManyToOne
	    @JoinColumn(name = "id_cliente")
	    private Clientes cliente;

	    
	    @ManyToOne
	    @JoinColumn(name = "id_empleado")
	    private Empleados empleado;

	    @ManyToOne
	    @JoinColumn(name = "id_metodo")
	    private MetodoPago metodoPago;

	   
	    @ManyToOne
	    @JoinColumn(name = "id_producto")
	    private Productos producto;

	
}

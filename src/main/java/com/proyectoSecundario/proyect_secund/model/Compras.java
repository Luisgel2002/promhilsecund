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
@Table (name="compras")
@DynamicInsert
@Getter @Setter
public class Compras {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id_compra")
	    private Integer idCompra;

	    @Column(name = "fecha")
	    private LocalDate fecha;

	    
	    
	    @ManyToOne
	    @JoinColumn(name = "id_proveedor")
	    private Proveedores proveedor;

	  
	    @ManyToOne
	    @JoinColumn(name = "id_empleado")
	    private Empleados empleado;

	    
	    @Column(name = "total")
	    private Double total;
}

package com.proyectoSecundario.proyect_secund.model;

import org.hibernate.annotations.DynamicInsert;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "proveedores")
@DynamicInsert
@Getter @Setter
public class Proveedores {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id_proveedor")
	    private Integer idProveedor;

	    @Column(name = "nombre_proveedor")
	    private String nombreProveedor;

	 
	    @Column(name = "contacto")
	    private String contacto;

	   
	    @Column(name = "telefono_provee")
	    private String telefono;

	    
	    @Column(name = "direccion")
	    private String direccion;
}

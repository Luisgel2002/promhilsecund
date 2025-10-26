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
@Table (name="empleados")
@DynamicInsert
@Getter @Setter
public class Empleados {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id_empleado")
	    private Integer idEmpleado;

	    @Column(name = "nombre_empleado")
	    private String nombreEmpleado;

	    @Column(name = "cargo")
	    private String cargo;

	    @Column(name = "correo")
	    private String correo;

	    @Column(name = "telefono_emple")
	    private String telefono;
}

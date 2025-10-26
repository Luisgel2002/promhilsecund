package com.proyectoSecundario.proyect_secund.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name="clientes")
@Getter @Setter
public class Clientes {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Integer idCliente;

    @Column(name = "nombre_cliente")
    private String nombreCliente;

    @Column(name = "correo")
    private String correo;

    @Column(name = "telefono_cli")
    private String telefono;
    
    @Column(name = "direccion")
    private String direccion;
}

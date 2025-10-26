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
@Table (name="metodos_pago")
@Getter @Setter
public class MetodoPago {
	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_metodo")
    private Integer id;


    @Column(name = "tipo_metodo")
    private String tipo;

  
    @Column(name = "descripcion")
    private String descripcion;

}

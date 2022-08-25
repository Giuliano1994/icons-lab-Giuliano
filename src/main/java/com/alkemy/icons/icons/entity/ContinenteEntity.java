package com.alkemy.icons.icons.entity;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity  // defino que esto va a ser una entidad
@Table (name = "continente")   // indico la tabla que se va a relacionar con esta entidad
@Getter    // defino los getter and setter a partir del import lombok
@Setter
public class ContinenteEntity {
	
	@Id   // la variable id va a ser un identificador
	@GeneratedValue (strategy = GenerationType.SEQUENCE)   //indico como se va a generar la tabla a partir de una estrategia "secuencia"
	 
	private long id;
	
	private String imagen;
	
	private String denominacion;
	

}

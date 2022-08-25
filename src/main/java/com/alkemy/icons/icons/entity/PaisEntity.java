package com.alkemy.icons.icons.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

import org.springframework.web.jsf.FacesContextUtils;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name = "pais")
@Getter
@Setter

public class PaisEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	private String imagen;
	
	private String denominacion;
	
	@Column (name = "cant_habitantes")
	private Long cantidadHabitantes;
	
	private Long superficie;
	
	// Relacion muchos a uno "muchos paises a un continente"
	// fetch = FetchType.EAGER -- inicializacion temprana, al crear un pais tiene que venir con su continente
	// cascade = CascadeType.ALL -- todas las operaciones sobre el pais son consecuentes con el continente, si elimino el pais de la bbdd se elimina el continente del registro
	
	// Como voy a Joinear la entidad con la tabla de continente
	// name = "continente_id" -- realizo el join a traves del id del continente
	// insertable = false -- no se inserta, solo lo uso para obtener informacion
	// updatable = false -- no se modifica,
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn (name = "continente_id", insertable = false, updatable = false)
	private ContinenteEntity continente;
	
	// name = "continente_id" -- apunta al continente
	// nullable = false -- un continente no puede ser nulo
	@Column (name = "continente_id", nullable = false)
	private Long continenteId;
	
	
	@ManyToMany(
			
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE
			})
	
	
	@JoinTable(
			
			name = "icon_pais",
			joinColumns = @JoinColumn (name = "pais_id"),
			inverseJoinColumns = @JoinColumn (name = "icon_id")
			)
	
	private Set<IconEntity> icons = new HashSet<>();


	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final PaisEntity other = (PaisEntity) obj;
		return other.id == this.id;
	}
	
	
	
	
	
	
	

}

package com.springframework.datajpa.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="clientes") //Caso la tabla se llame igual a la clase no seria necesario poner la anotacion
public class Cliente implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id; //llave primaria autoincremental
	
	@NotEmpty //Em spring boot 2 esta depreciado temos que usar javax.validation.contraints
	private String nombre;
	@NotEmpty
	private String apellido;
	@NotEmpty
	@Email //Em spring boot 2 esta depreciado temos que usar javax.validation.contraints
	private String email;
	
	@NotNull
	@Column(name="create_at")
	@Temporal(TemporalType.DATE) // Indica el tipo de date que queremos guardar en la BD (agarra el de java y lo convierte al date de BD)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createAt; //Se coloca la anotacion cuando el nombre de la columna es diferente
	
//	Es llamado antes que se llame el metodo persist
//	@PrePersist (esta ahora mediante formmulario html
//	public void prePersist() {
//		createAt = new Date();
//	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	
	
	
}

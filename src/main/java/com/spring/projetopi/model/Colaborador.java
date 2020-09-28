package com.spring.projetopi.model;

import javax.persistence.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Email;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "COLABORADOR")
public class Colaborador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_COLABORADOR", updatable = false, nullable = false)
	@Getter @Setter private Long colaborador_id;
	
	@ManyToOne
	@Getter @Setter private Empresa empresa;
	
	@NotNull
	@Getter @Setter private String nome;
	
	@Email(message = "O email tem que ser valido")
	@Getter @Setter private String email;
	
	@NotNull
	@Getter @Setter private String senha;
}

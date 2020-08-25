package com.spring.projetopi.model;

import javax.persistence.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Email;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "COLABORADOR")
public class Colaborador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter @Setter private Long colaborador_id;
	
	@ManyToOne
	@Getter @Setter private Empresa empresa;
	
	@NotBlank(message = "Nome e obrigatorio")
	@Getter @Setter private String nome;
	
	@Email(message = "O email tem que ser valido")
	@Getter @Setter private String email;
	
	@NotBlank(message = "Senha e obrigatorio")
	@Getter @Setter private String senha;
}

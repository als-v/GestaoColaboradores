package com.spring.projetopi.model;

import javax.persistence.*;

import javax.validation.constraints.Email;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "empresa")
public class Empresa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="empresa_id", updatable = false, nullable = false)
	@Getter @Setter private long empresa_id;
	
	@Column(name="email", nullable = false)
	@Email(message = "O email tem que ser valido")
	@Getter @Setter private String email;
	
	@Column(name="senha", nullable = false)
	@Getter @Setter private String senha;
	
	@Column(name="nome", nullable = false)
	@Getter @Setter private String nome;
	
	@Column(name="cnpj", nullable = false)
	@Getter @Setter private String cnpj;

}

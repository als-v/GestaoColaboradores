package com.spring.projetopi.model;

import java.util.List;

import javax.persistence.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Email;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "EMPRESA")
public class Empresa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_EMPRESA", updatable = false, nullable = false)
	@Getter @Setter private Long empresa_id;
	
	//@OneToMany
	//@Getter @Setter private List<Colaborador> colaboradores;
	
	@Email(message = "O email tem que ser valido")
	@Getter @Setter private String email;
	
	@NotBlank(message = "Senha nao pode ser vazia")
	@Getter @Setter private String senha;
	
	@NotBlank(message = "Nome e obrigatorio")
	@Getter @Setter private String nome;
	
	@NotBlank(message = "CNPJ e obrigatorio")
	@Getter @Setter private String cnpj;

}

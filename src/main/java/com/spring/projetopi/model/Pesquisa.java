package com.spring.projetopi.model;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pesquisa")
public class Pesquisa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="pesquisa_id", updatable = false, nullable = false)
	@Getter @Setter private long pesquisa_id;
	
	@ManyToOne
	@Getter @Setter private Empresa empresa;
	
	@OneToMany
	@Getter @Setter private List<Questao> questoes;
	
	@Column(name="nome", columnDefinition = "varchar(255) default 'Pesquisa sem nome'")
	@Getter @Setter private String nome;
	
	@Column(name="acertoGeral", columnDefinition = "float default 0")
	@Getter @Setter private float acertoGeral;
}

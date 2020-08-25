package com.spring.projetopi.model;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "PESQUISA")
public class Pesquisa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter @Setter private Long pesquisa_id;
	
	@ManyToOne
	@Getter @Setter private Empresa empresa;
	
	@OneToMany
	@Getter @Setter private List<Questao> questoes;
}

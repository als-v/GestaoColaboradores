package com.spring.projetopi.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "alternativa")
public class Alternativa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="alternativa_id", updatable = false, nullable = false)
	@Getter @Setter private long alternativa_id;
	
	@Column(name="alternativa", nullable = false)
	@Getter @Setter private int alternativa;
	
	@Column(name="descricao", nullable = false)
	@Getter @Setter private String descricao;
	
	@Column(name="correto", nullable = false)
	@Getter @Setter private boolean correto;
}

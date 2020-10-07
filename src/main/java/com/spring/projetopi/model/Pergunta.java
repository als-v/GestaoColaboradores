package com.spring.projetopi.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pergunta")
public class Pergunta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pergunta_id", updatable = false, nullable = false)
	@Getter @Setter private long pergunta_id;
	
	@Column(name="pergunta", nullable = false)
	@Getter @Setter private String pergunta;
}

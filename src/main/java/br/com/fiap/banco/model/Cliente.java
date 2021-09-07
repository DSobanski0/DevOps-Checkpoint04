package br.com.fiap.banco.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Data
@Entity
@SequenceGenerator(name = "SQ_CLIENTE", allocationSize = 1, sequenceName = "SQ_CLIENTE")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_CLIENTE")
	private Long id;
	
	private String nome;
	
	private String cpf;
}

package br.com.fiap.banco.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Data
@Entity
@SequenceGenerator(name = "SQ_CONTA", allocationSize = 1, sequenceName = "SQ_CONTA")
public class Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_CONTA")
	private Long id;
	
	private String titular;
	
	private Integer agencia;
	
	private Integer numero;

	private Double saldo = 0.0;
}

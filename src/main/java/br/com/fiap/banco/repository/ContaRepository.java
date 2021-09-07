package br.com.fiap.banco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.banco.model.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long> {

}

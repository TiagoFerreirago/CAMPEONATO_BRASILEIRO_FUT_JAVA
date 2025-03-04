package br.com.cbf.campeonatobrasileiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cbf.campeonatobrasileiro.model.Jogo;

public interface JogoRepository extends JpaRepository<Jogo, Integer> {

}

package br.com.cbf.campeonatobrasileiro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cbf.campeonatobrasileiro.model.Equipe;
import br.com.cbf.campeonatobrasileiro.model.Jogo;

public interface JogoRepository extends JpaRepository<Jogo, Integer> {

	List<Jogo> findBytimeCasaAndEncerrado(Equipe equipe1, Boolean encerrado);
	List<Jogo> findBytimeForaAndEncerrado(Equipe equipe2, Boolean encerrado);
	List<Jogo> findByEncerrado(Boolean encerrado);

}

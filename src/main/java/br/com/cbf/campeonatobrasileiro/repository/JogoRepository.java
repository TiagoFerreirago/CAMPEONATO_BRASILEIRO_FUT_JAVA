package br.com.cbf.campeonatobrasileiro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.cbf.campeonatobrasileiro.model.Equipe;
import br.com.cbf.campeonatobrasileiro.model.Jogo;

public interface JogoRepository extends JpaRepository<Jogo, Integer> {
	@Query("SELECT j FROM Jogo j WHERE j.timeCasa = :timeCasa AND j.encerrado = :encerrado")
	List<Jogo> buscarPorTimeCasa(@Param("timeCasa") Equipe timeCasa, @Param("encerrado") Boolean encerrado);

	@Query("SELECT j FROM Jogo j WHERE j.timeFora = :timeFora AND j.encerrado = :encerrado")
	List<Jogo> buscarPorTimeFora(@Param("timeFora") Equipe timeFora, @Param("encerrado") Boolean encerrado);
	List<Jogo> findByEncerrado(Boolean encerrado);

}

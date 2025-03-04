package br.com.cbf.campeonatobrasileiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cbf.campeonatobrasileiro.model.Equipe;

public interface EquipeRepository extends JpaRepository<Equipe, Long> {

}

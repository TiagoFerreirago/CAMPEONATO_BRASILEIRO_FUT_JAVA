package br.com.cbf.campeonatobrasileiro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cbf.campeonatobrasileiro.model.Equipe;
import br.com.cbf.campeonatobrasileiro.repository.EquipeRepository;

@Service
public class EquipeService {
	
	@Autowired
	private EquipeRepository equipeRepository;
	
	
	public void cadastrarEquipe(Equipe equipe) {
		
			equipeRepository.save(equipe);

	}
	
	
	public List<Equipe> listarEquipes(){
		
		return equipeRepository.findAll();
	}

}

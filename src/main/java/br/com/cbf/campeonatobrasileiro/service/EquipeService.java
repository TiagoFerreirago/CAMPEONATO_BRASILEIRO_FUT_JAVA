package br.com.cbf.campeonatobrasileiro.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cbf.campeonatobrasileiro.dto.EquipeDTO;
import br.com.cbf.campeonatobrasileiro.model.Equipe;
import br.com.cbf.campeonatobrasileiro.repository.EquipeRepository;

@Service
public class EquipeService {
	
	@Autowired
	private EquipeRepository equipeRepository;
	
	
	public void cadastrarEquipe(EquipeDTO equipeDto) {
		
		Equipe equipe = new Equipe(equipeDto);
			equipeRepository.save(equipe);

	}
	
	public List<EquipeDTO> listarEquipes(){
		
		List<Equipe>listEquipe = equipeRepository.findAll();
		List<EquipeDTO>parseEquipeDto = listEquipe.stream().map(p -> new EquipeDTO(p)).collect(Collectors.toList());
		
		return parseEquipeDto;
	}
	
	public EquipeDTO buscarEquipe(Long id) throws AccountNotFoundException {
		
		Equipe equipe = equipeRepository.findById(id).orElseThrow(() -> new AccountNotFoundException("Equipe nao foi encontrada!"));
		
		return new EquipeDTO(equipe);
	}

}

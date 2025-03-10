package br.com.cbf.campeonatobrasileiro.controller;

import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cbf.campeonatobrasileiro.dto.EquipeDTO;
import br.com.cbf.campeonatobrasileiro.service.EquipeService;

@RequestMapping(value = "/equipes")
@RestController
public class EquipeController {

	@Autowired
	private EquipeService equipeService;
	
	@GetMapping
	public ResponseEntity<List<EquipeDTO>> getListaEquipes(){
		
		List<EquipeDTO> equipes = equipeService.listarEquipes();
		return ResponseEntity.ok().body(equipes);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<EquipeDTO> getEquipe(@PathVariable Long id) throws AccountNotFoundException{
		
		EquipeDTO equipe = equipeService.buscarEquipe(id);
		return ResponseEntity.ok().body(equipe);
	}
	
	@PostMapping
	public ResponseEntity<Void> setEquipe(@RequestBody EquipeDTO equipe){
		
		equipeService.cadastrarEquipe(equipe);
		
		return  ResponseEntity.ok().body(null);
	}
	
}

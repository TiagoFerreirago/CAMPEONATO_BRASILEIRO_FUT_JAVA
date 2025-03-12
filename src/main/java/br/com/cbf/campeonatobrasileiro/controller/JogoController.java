package br.com.cbf.campeonatobrasileiro.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cbf.campeonatobrasileiro.model.Jogo;
import br.com.cbf.campeonatobrasileiro.service.JogoService;

@RestController
@RequestMapping(value = "/jogos")
public class JogoController {

	@Autowired
	private JogoService jogoService;
	
	@PostMapping(value = "/gerar-jogos")
	public ResponseEntity<?>gerarJogos(){
		jogoService.jogos(LocalDateTime.now());
		return ResponseEntity.ok().body(LocalDateTime.now());
	}
	
	public ResponseEntity<List<Jogo>>obterJogos(){
		
	    return ResponseEntity.ok().body(jogoService.obterJogos());
	}
}

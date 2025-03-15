package br.com.cbf.campeonatobrasileiro.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cbf.campeonatobrasileiro.dto.FinalizarJogoDTO;
import br.com.cbf.campeonatobrasileiro.dto.JogoDTO;
import br.com.cbf.campeonatobrasileiro.service.JogoService;

@RestController
@RequestMapping(value = "/jogos")
public class JogoController {

	@Autowired
	private JogoService jogoService;
	
	@PostMapping(value = "/gerar-jogos")
	public ResponseEntity<?>gerarJogos(){
		jogoService.jogos(LocalDateTime.now());
		return ResponseEntity.ok(null);
	}
	@GetMapping
	public ResponseEntity<List<JogoDTO>>obterListaJogos(){
		
	    return ResponseEntity.ok().body(jogoService.obterListaJogos());
	}
	
	@PostMapping(value = "/finalizar/{id}")
	public ResponseEntity<JogoDTO>finalizar(@PathVariable("id")Integer id, @RequestBody FinalizarJogoDTO jogoDto) throws Exception{
		
		JogoDTO dto = jogoService.finalizar(id, jogoDto);
		return ResponseEntity.ok().body(dto);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<JogoDTO>obterJogo(@PathVariable("id")Integer id) throws Exception{
		
		JogoDTO jogoDto =jogoService.obterJogo(id);
		return ResponseEntity.ok().body(jogoDto);
	}
}

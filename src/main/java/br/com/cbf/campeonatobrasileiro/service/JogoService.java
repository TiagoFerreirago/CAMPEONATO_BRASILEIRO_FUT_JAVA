package br.com.cbf.campeonatobrasileiro.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cbf.campeonatobrasileiro.dto.ClassificacaoDTO;
import br.com.cbf.campeonatobrasileiro.dto.ClassificacaoTimeDTO;
import br.com.cbf.campeonatobrasileiro.dto.EquipeDTO;
import br.com.cbf.campeonatobrasileiro.dto.FinalizarJogoDTO;
import br.com.cbf.campeonatobrasileiro.dto.JogoDTO;
import br.com.cbf.campeonatobrasileiro.model.Equipe;
import br.com.cbf.campeonatobrasileiro.model.Jogo;
import br.com.cbf.campeonatobrasileiro.repository.EquipeRepository;
import br.com.cbf.campeonatobrasileiro.repository.JogoRepository;

@Service
public class JogoService {
	
	
	@Autowired
	private JogoRepository jogoRepository;
	@Autowired
	private EquipeRepository equipeRepository;
	
	public void jogos(LocalDateTime primeiraRodada){

		final List<Equipe> equipes = equipeRepository.findAll();
		List<Equipe> all1 = new ArrayList<>();
		List<Equipe> all2 = new ArrayList<>();
		all1.addAll(equipes);
		all2.addAll(equipes);

		jogoRepository.deleteAll();

		List<Jogo> jogos= new ArrayList<>();

		int t = equipes.size();
		int m = equipes.size() /2;

		LocalDateTime dataJogo = primeiraRodada;
		Integer rodada = 0;
		
		for(int i = 0; i < t - 1; i++){
			rodada = i + 1;
		   for(int j = 0; j < m; j++){
			//Mando de campo
			Equipe equipe1;
			Equipe equipe2;
			if(j % 2 == 1 || i % 2 == 1 && j == 0){
				equipe1 = equipes.get(t - j -1);
				equipe2 = equipes.get(j);
			}
			else{
				equipe1 = equipes.get(j);
				equipe2 = equipes.get(t - j -1);
			}
			if(equipe1 == null){
				System.out.println("Equipe 1 é nula");
			}
			jogos.add(gerarJogos(dataJogo, rodada, equipe1, equipe2));
			dataJogo = dataJogo.plusDays(7);
		  }
			equipes.add(1, equipes.remove(equipes.size() - 1));
	    }
		 jogos.forEach(jogo -> System.out.println(jogo));
	     jogoRepository.saveAll(jogos);
	     
	     List<Jogo> jogos2 = new ArrayList<>();

	     jogos.forEach(jogo -> {
	     Equipe equipe1 = jogo.getTimeFora();
		 Equipe equipe2 = jogo.getTimeCasa();
		  
		 jogos2.add(gerarJogos(jogo.getDataJogo().plusDays(7 * jogos.size()), jogo.getRodada() + jogos.size(), equipe1, equipe2));
	     });	
	     jogoRepository.saveAll(jogos2);
	}

	private Jogo gerarJogos(LocalDateTime dataJogo, Integer rodada, Equipe equipe1, Equipe equipe2) {
		
		Jogo jogo = new Jogo();
		jogo.setTimeCasa(equipe1);
		jogo.setTimeFora(equipe2);
		jogo.setRodada(rodada);
		jogo.setDataJogo(dataJogo);
		jogo.setEncerrado(false);
		jogo.setGolsTimeCasa(0);
		jogo.setGolsTimeFora(0);
		jogo.setPublicoPagante(0);
		return jogo;
	}

	public List<JogoDTO> obterListaJogos() {
		
		List<Jogo> jogo = jogoRepository.findAll();
		return jogo.stream().map( j -> new JogoDTO(j)).collect(Collectors.toList());
	}
	
	public JogoDTO obterJogo(Integer id) throws Exception {
		
		Jogo jogo = jogoRepository.findById(id).orElseThrow(() -> new Exception("Equipe não encontrada"));
		return new JogoDTO(jogo);
	}
	
	public JogoDTO finalizar(Integer id, FinalizarJogoDTO jogoDto) throws Exception {
		
		Jogo jogo = jogoRepository.findById(id).orElseThrow(() -> new Exception("Equipe não encontrada!"));
		jogo.setGolsTimeCasa(jogoDto.getGolsTimeCasa());
		jogo.setGolsTimeFora(jogoDto.getGolsTimeFora());
		jogo.setEncerrado(true);
		jogo.setPublicoPagante(jogoDto.getPublicoPagante());
		Jogo jogoFinalizado = jogoRepository.save(jogo);
		return new JogoDTO(jogoFinalizado);
	}
	
	public ClassificacaoDTO classificacao() {
		
		ClassificacaoDTO classificacaoDto = new ClassificacaoDTO();
		
		List<Equipe> equipes = equipeRepository.findAll();
	
		equipes.forEach( time -> {
			
			List<Jogo> equipeMandante = jogoRepository.buscarPorTimeCasa(time, true);
			List<Jogo> equipeVisitante = jogoRepository.buscarPorTimeFora(time, true);
			AtomicReference<Integer>vitorias = new AtomicReference<Integer>(0);
			AtomicReference<Integer>empates = new AtomicReference<Integer>(0);
			AtomicReference<Integer>derrotas = new AtomicReference<Integer>(0);
			AtomicReference<Integer>golsSofridos = new AtomicReference<Integer>(0);
			AtomicReference<Integer>golsMarcados = new AtomicReference<Integer>(0);
			equipeMandante.forEach( mandante -> {
				if(mandante.getGolsTimeCasa() > mandante.getGolsTimeFora()) {
					vitorias.getAndSet(vitorias.get() + 1);
				}
				else if(mandante.getGolsTimeCasa() < mandante.getGolsTimeFora()) {
					derrotas.getAndSet(derrotas.get() + 1);
				}
				else {
					empates.getAndSet( empates.get() + 1);
				}
				golsMarcados.set(golsMarcados.get() + mandante.getGolsTimeCasa());
				golsSofridos.set(golsSofridos.get() + mandante.getGolsTimeFora());
			});
			
			equipeVisitante.forEach(visitante -> {
				if(visitante.getGolsTimeFora() > visitante.getGolsTimeCasa()) {
					vitorias.getAndSet(vitorias.get() + 1);
				}
				else if(visitante.getGolsTimeFora() < visitante.getGolsTimeCasa()) {
					derrotas.getAndSet(derrotas.get() + 1);
				}
				else {
					empates.getAndSet( empates.get() + 1);
				}
				golsMarcados.set(golsMarcados.get() + visitante.getGolsTimeFora());
				golsSofridos.set(golsSofridos.get() + visitante.getGolsTimeCasa());
			});
			ClassificacaoTimeDTO classificacaoTimeDto =  new ClassificacaoTimeDTO();
			classificacaoTimeDto.setDerrotas(derrotas.get());
			classificacaoTimeDto.setEmpates(empates.get());
			classificacaoTimeDto.setIdTime(time.getId());
			classificacaoTimeDto.setEquipe(time.getNome());
			classificacaoTimeDto.setPontos((vitorias.get() * 3) + empates.get() );
			classificacaoTimeDto.setVitorias(vitorias.get());
			classificacaoTimeDto.setGolsMarcados(golsMarcados.get());
			classificacaoTimeDto.setGolsSofridos(golsSofridos.get());
			classificacaoTimeDto.setJogos(derrotas.get() + empates.get() + vitorias.get());
			
			classificacaoDto.getTimes().add(classificacaoTimeDto);
			
		});
		Collections.sort(classificacaoDto.getTimes(), Collections.reverseOrder());
		
		int posicao = 1;
		
		for (ClassificacaoTimeDTO timeDto : classificacaoDto.getTimes()) {
			timeDto.setPosicao(posicao ++);
		}	
		
		return classificacaoDto;
	}

}

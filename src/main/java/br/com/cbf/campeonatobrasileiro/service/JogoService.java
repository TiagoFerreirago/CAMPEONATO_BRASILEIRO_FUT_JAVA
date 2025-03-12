package br.com.cbf.campeonatobrasileiro.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

		equipeRepository.deleteAll();

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

}

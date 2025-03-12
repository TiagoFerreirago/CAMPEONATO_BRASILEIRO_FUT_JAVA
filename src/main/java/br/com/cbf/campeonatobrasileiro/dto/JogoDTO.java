package br.com.cbf.campeonatobrasileiro.dto;

import java.time.LocalDateTime;

import br.com.cbf.campeonatobrasileiro.model.Equipe;
import br.com.cbf.campeonatobrasileiro.model.Jogo;

public class JogoDTO {

	private Integer id;
	private Equipe timeCasa;
	private Equipe timeFora;
	private Integer golsTimeCasa;
	private Integer golsTimeFora;
	private Integer publicoPagante;
	private LocalDateTime dataJogo;
	private Integer rodada;
	private Boolean encerrado;
	
	public JogoDTO(Jogo jogo) {
		
		this.id = jogo.getId();
		this.timeCasa = jogo.getTimeCasa();
		this.timeFora = jogo.getTimeFora();
		this.golsTimeCasa = jogo.getGolsTimeCasa();
		this.golsTimeFora = jogo.getGolsTimeFora();
		this.publicoPagante = jogo.getPublicoPagante();
		this.dataJogo = jogo.getDataJogo();
		this.rodada = jogo.getRodada();
		this.encerrado = jogo.getEncerrado();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Equipe getTimeCasa() {
		return timeCasa;
	}
	public void setTimeCasa(Equipe timeCasa) {
		this.timeCasa = timeCasa;
	}
	public Equipe getTimeFora() {
		return timeFora;
	}
	public void setTimeFora(Equipe timeFora) {
		this.timeFora = timeFora;
	}
	public Integer getGolsTimeCasa() {
		return golsTimeCasa;
	}
	public void setGolsTimeCasa(Integer golsTimeCasa) {
		this.golsTimeCasa = golsTimeCasa;
	}
	public Integer getGolsTimeFora() {
		return golsTimeFora;
	}
	public void setGolsTimeFora(Integer golsTimeFora) {
		this.golsTimeFora = golsTimeFora;
	}
	public Integer getPublicoPagante() {
		return publicoPagante;
	}
	public void setPublicoPagante(Integer publicoPagante) {
		this.publicoPagante = publicoPagante;
	}
	public LocalDateTime getDataJogo() {
		return dataJogo;
	}
	public void setDataJogo(LocalDateTime dataJogo) {
		this.dataJogo = dataJogo;
	}
	public Integer getRodada() {
		return rodada;
	}
	public void setRodada(Integer rodada) {
		this.rodada = rodada;
	}
	public Boolean getEncerrado() {
		return encerrado;
	}
	public void setEncerrado(Boolean encerrado) {
		this.encerrado = encerrado;
	}
	
	
	
	
}

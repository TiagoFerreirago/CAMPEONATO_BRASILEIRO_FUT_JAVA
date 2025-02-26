package br.com.cbf.campeonatobrasileiro.model;

import jakarta.persistence.Entity;

@Entity
public class Jogo {

	private Time timeCasa;
	private Time timeFora;
	private Integer golsTimeCasa;
	private Integer golsTimeFora;
	private Integer publicoPagante;
	
	
	public Time getTimeCasa() {
		return timeCasa;
	}
	public void setTimeCasa(Time timeCasa) {
		this.timeCasa = timeCasa;
	}
	public Time getTimeFora() {
		return timeFora;
	}
	public void setTimeFora(Time timeFora) {
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
	
	
}

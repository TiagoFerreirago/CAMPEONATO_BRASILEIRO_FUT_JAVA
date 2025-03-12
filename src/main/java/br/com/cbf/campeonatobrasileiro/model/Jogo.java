package br.com.cbf.campeonatobrasileiro.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_game")
public class Jogo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "timeCasa")
	private Equipe timeCasa;
	@ManyToOne
	@JoinColumn(name = "timeFora")
	private Equipe timeFora;
	private Integer golsTimeCasa;
	private Integer golsTimeFora;
	private Integer publicoPagante;
	private LocalDateTime dataJogo;
	private Integer rodada;
	private Boolean encerrado;
	
	public Jogo() {}
	
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
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

package br.com.cbf.campeonatobrasileiro.model;

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
	private String uuid;
	
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
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getUuid() {
		return uuid;
	}
	
	
}

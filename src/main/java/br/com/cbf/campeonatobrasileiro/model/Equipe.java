package br.com.cbf.campeonatobrasileiro.model;

import br.com.cbf.campeonatobrasileiro.dto.EquipeDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Equipe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 20, name = "nome_time")
	private String nome;
	@Column(length = 5)
	private String sigla;
	@Column(length = 5)
	private String uf;
	@Column(length = 50)
	private String estadio;
	
	public Equipe() {}
	
	public Equipe(EquipeDTO equipeDto) {
	
	this.nome = equipeDto.getNome();
	this.sigla = equipeDto.getSigla();
	this.uf = equipeDto.getUf();
	this.estadio = equipeDto.getEstadio();
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getEstadio() {
		return estadio;
	}
	public void setEstadio(String estadio) {
		this.estadio = estadio;
	}

	
}

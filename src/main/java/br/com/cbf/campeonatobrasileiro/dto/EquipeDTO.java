package br.com.cbf.campeonatobrasileiro.dto;

import br.com.cbf.campeonatobrasileiro.model.Equipe;

public class EquipeDTO {

	private Long id;
		private String nome;
		private String sigla;
		private String uf;	
		private String estadio;

	public EquipeDTO(Equipe equipe) {
		
		this.id = equipe.getId();
		this.nome = equipe.getNome();
		this.sigla = equipe.getSigla();
		this.uf = equipe.getUf();
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


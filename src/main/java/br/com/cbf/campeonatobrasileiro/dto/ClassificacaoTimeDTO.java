package br.com.cbf.campeonatobrasileiro.dto;

public class ClassificacaoTimeDTO implements Comparable<ClassificacaoTimeDTO>{

	private String equipe;
	private Long idTime;
	private Integer posicao;
	private Integer pontos;
	private Integer jogos;
	private Integer vitorias;
	private Integer empates;
	private Integer derrotas;
	private Integer golsMarcados;
	private Integer golsSofridos;
	
	public String getEquipe() {
		return equipe;
	}
	public void setEquipe(String equipe) {
		this.equipe = equipe;
	}
	public Long getIdTime() {
		return idTime;
	}
	public void setIdTime(Long long1) {
		this.idTime = long1;
	}
	public Integer getPosicao() {
		return posicao;
	}
	public void setPosicao(Integer posicao) {
		this.posicao = posicao;
	}
	public Integer getPontos() {
		return pontos;
	}
	public void setPontos(Integer pontos) {
		this.pontos = pontos;
	}
	public Integer getJogos() {
		return jogos;
	}
	public void setJogos(Integer jogos) {
		this.jogos = jogos;
	}
	public Integer getVitorias() {
		return vitorias;
	}
	public void setVitorias(Integer vitorias) {
		this.vitorias = vitorias;
	}
	public Integer getEmpates() {
		return empates;
	}
	public void setEmpates(Integer empates) {
		this.empates = empates;
	}
	public Integer getDerrotas() {
		return derrotas;
	}
	public void setDerrotas(Integer derrotas) {
		this.derrotas = derrotas;
	}
	public Integer getGolsMarcados() {
		return golsMarcados;
	}
	public void setGolsMarcados(Integer golsMarcados) {
		this.golsMarcados = golsMarcados;
	}
	public Integer getGolsSofridos() {
		return golsSofridos;
	}
	public void setGolsSofridos(Integer golsSofridos) {
		this.golsSofridos = golsSofridos;
	}
	@Override
	public int compareTo(ClassificacaoTimeDTO o) {
		
		return this.getPontos().compareTo(o.getPontos());

	}
	
	
}

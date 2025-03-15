package br.com.cbf.campeonatobrasileiro.dto;

public class FinalizarJogoDTO {

	private Integer golsTimeCasa;
	private Integer golsTimeFora;
	private Integer publicoPagante;
	
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

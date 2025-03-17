package br.com.cbf.campeonatobrasileiro.dto;

import java.util.ArrayList;
import java.util.List;

public class ClassificacaoDTO {

	private List<ClassificacaoTimeDTO> times = new ArrayList<ClassificacaoTimeDTO>();

	public List<ClassificacaoTimeDTO> getTimes() {
		return times;
	}

	public void setTimes(List<ClassificacaoTimeDTO> times) {
		this.times = times;
	}
	
	
	
	
}

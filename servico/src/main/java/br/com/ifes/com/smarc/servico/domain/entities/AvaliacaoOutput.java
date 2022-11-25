package br.com.ifes.com.smarc.servico.domain.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AvaliacaoOutput {
	private Double obesidade;
	private Double tabagismo;
	private Double sedentarismo;
	private Double pressaoSistolica;
	private Double pressaoDiastolica;

	private Double grauCerteza;
	private Double grauContradicao;
	private String avaliacao;
}

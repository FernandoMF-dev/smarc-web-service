package br.com.ifes.com.smarc.tabagismo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AgenteTabagismoModel implements Serializable {

	private Integer minutosAposAcordarPrimeiroCigarro;

	private Boolean dificilNaoFumarLocaisProibidos;

	private Integer qualCigarroDoDiaDaMaisSatisfacao;

	private Integer quantosCigarrosFumaDiariamente;

	private Boolean fumaMaisfrequenteManha;

	private Boolean fumaMesmoDoente;

	private Integer totalPontos;

	private Double resultado;

}

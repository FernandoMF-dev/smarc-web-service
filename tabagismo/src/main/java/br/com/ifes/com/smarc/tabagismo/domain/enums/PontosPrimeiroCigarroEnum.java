package br.com.ifes.com.smarc.tabagismo.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PontosPrimeiroCigarroEnum {
	PONTOS_3(3, 0, 5),
	PONTOS_2(2, 5, 30),
	PONTOS_1(1, 30, 60);

	public static final Integer PONTUACAO_PADRAO = 0;

	private final Integer pontuacao;
	private final Integer minutosMin;
	private final Integer minutosMax;
}

package br.com.ifes.com.smarc.tabagismo.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PontosCigarrosDiariosEnum {
	PONTOS_1(1, 10, 20),
	PONTOS_2(2, 20, 30),
	PONTOS_3(3, 30, Integer.MAX_VALUE);

	public static final Integer PONTUACAO_PADRAO = 0;

	private final Integer pontuacao;
	private final Integer quantidadeMin;
	private final Integer quantidadeMax;
}

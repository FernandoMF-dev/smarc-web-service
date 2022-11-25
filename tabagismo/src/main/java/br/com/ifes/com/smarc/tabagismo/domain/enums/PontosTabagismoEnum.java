package br.com.ifes.com.smarc.tabagismo.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PontosTabagismoEnum {
	PONTOS_1(0.25, 3),
	PONTOS_2(0.5, 5),
	PONTOS_3(0.75, 8),
	PONTOS_4(1.0, Integer.MAX_VALUE);

	public static final Double PONTUACAO_PADRAO = 0.0;

	private final Double pontuacao;
	private final Integer pontosMax;
}

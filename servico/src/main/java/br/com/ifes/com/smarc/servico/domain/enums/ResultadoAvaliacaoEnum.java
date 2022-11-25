package br.com.ifes.com.smarc.servico.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultadoAvaliacaoEnum {
	FALSO("FALSO"),
	VERDADEIRO("VERDADEIRO"),
	INCONSISTENTE("INCONSISTENTE"),
	INDETERMINADO("INDETERMINADO"),
	QUASE_FALSO("QUASE FALSO"),
	QUASE_VERDADEIRO("QUASE VERDADE");

	private final String descricao;
}

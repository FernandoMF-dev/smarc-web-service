package br.com.ifes.com.smarc.servico.domain.entities;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AvaliacaoInput {
	@NotNull
	@Valid
	private AgenteObesidade agenteObesidade;

	@NotNull
	@Valid
	private AgenteTabagismo agenteTabagismo;

	@NotNull
	@Valid
	private AgenteSedentarismo agenteSedentarismo;

	@NotNull
	@Valid
	private AgentePressaoSistolica agentePressaoSistolica;

	@NotNull
	@Valid
	private AgentePressaoDiastolica agentePressaoDiastolica;
}

package br.com.ifes.com.smarc.servico.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AgentePressaoDiastolica {

	@NotNull(message = "O campo pressão diastólica não pode ser nulo!")
	private Double pressaoDiastolica;

	private Double resultado;

}

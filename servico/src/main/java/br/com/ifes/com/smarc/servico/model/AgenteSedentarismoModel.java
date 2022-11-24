package br.com.ifes.com.smarc.servico.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AgenteSedentarismoModel implements Serializable {

	@NotNull(message = "O campo frequência de atividade física durante a semana não pode ser nulo!")
	private Integer frequenciaAtividadeFisicaSemana;

	private Double resultado;

}

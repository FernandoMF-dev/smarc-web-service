package br.com.ifes.com.smarc.sedentarismo.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AgenteSedentarismo implements Serializable {

	private Integer frequenciaAtividadeFisicaSemana;

	private Double resultado;

}

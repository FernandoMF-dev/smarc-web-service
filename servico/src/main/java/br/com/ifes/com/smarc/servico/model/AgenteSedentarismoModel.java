package br.com.ifes.com.smarc.servico.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AgenteSedentarismoModel implements Serializable {

	private Integer frequenciaAtividadeFisicaSemana;

}

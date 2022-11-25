package br.com.ifes.com.smarc.servico.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AgentePressaoSistolica implements Serializable {

	@NotNull(message = "O campo pressão sistólica não pode ser nulo!")
	private Double pressaoSistolica;

	private Double resultado;

}

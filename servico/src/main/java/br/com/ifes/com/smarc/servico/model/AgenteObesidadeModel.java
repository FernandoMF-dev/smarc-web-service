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
public class AgenteObesidadeModel implements Serializable {

	@NotNull(message = "O campo altura não pode ser nulo!")
	private Double altura;

	@NotNull(message = "O campo peso não pode ser nulo!")
	private Double peso;

	private Double imc;

	private Double resultado;

}

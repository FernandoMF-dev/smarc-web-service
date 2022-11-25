package br.com.ifes.com.smarc.servico.domain.entities;

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
public class AgenteTabagismo implements Serializable {

	@NotNull(message = "O campo minutos após acordar em que se fuma o primeiro cigarro não pode ser nulo!")
	private Integer minutosAposAcordarPrimeiroCigarro;

	@NotNull(message = "O campo é difícil fumar em locais não proibidos não pode ser nulo!")
	private Boolean dificilNaoFumarLocaisProibidos;

	@NotNull(message = "O campo qual cigarro do dia da mais satisfação não pode ser nulo!")
	private Integer qualCigarroDoDiaDaMaisSatisfacao;

	@NotNull(message = "O campo quantos cigarros fuma diariamente não pode ser nulo!")
	private Integer quantosCigarrosFumaDiariamente;

	@NotNull(message = "O campo fuma mais frequentemente pela manhã não pode ser nulo!")
	private Boolean fumaMaisfrequenteManha;

	@NotNull(message = "O campo fuma mesmo doente não pode ser nulo!")
	private Boolean fumaMesmoDoente;

	private Integer totalPontos;

	private Double resultado;

}

package br.com.ifes.com.smarc.pressaosistolica.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AgentePressaoSistolica implements Serializable {

	private Double pressaoSistolica;

	private Double resultado;

}

package br.com.ifes.com.smarc.pressaosistolica.service;

import br.com.ifes.com.smarc.pressaosistolica.model.AgentePressaoSistolica;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PressaoSistolicaServico {

	public AgentePressaoSistolica calcularResultado(AgentePressaoSistolica agentePressaoSistolica) {
		if (agentePressaoSistolica.getPressaoSistolica() <= 120) {
			agentePressaoSistolica.setResultado(0.0);
		} else if (agentePressaoSistolica.getPressaoSistolica() >= 140) {
			agentePressaoSistolica.setResultado(1.0);
		} else {
			agentePressaoSistolica.setResultado((agentePressaoSistolica.getPressaoSistolica() - 120) / (140 - 120));
		}

		return agentePressaoSistolica;
	}

}

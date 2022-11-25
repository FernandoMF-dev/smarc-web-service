package br.com.ifes.com.smarc.pressaosistolica.service;

import br.com.ifes.com.smarc.pressaosistolica.domain.entities.AgentePressaoSistolica;
import br.com.ifes.com.smarc.pressaosistolica.utils.NumberUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PressaoSistolicaService {

	private static final Double PRESSAO_MIN = 120.0;
	private static final Double PRESSAO_MAX = 140.0;

	public AgentePressaoSistolica calcularResultado(AgentePressaoSistolica agentePressaoSistolica) {
		Double resultado = (agentePressaoSistolica.getPressaoSistolica() - PRESSAO_MIN) / (PRESSAO_MAX - PRESSAO_MIN);
		agentePressaoSistolica.setResultado(NumberUtils.limitToInterval(resultado, 0.0, 1.0));
		return agentePressaoSistolica;
	}

}

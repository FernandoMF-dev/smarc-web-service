package br.com.ifes.col.smarc.pressaodiastolica.service;

import br.com.ifes.col.smarc.pressaodiastolica.domain.entities.AgentePressaoDiastolica;
import br.com.ifes.col.smarc.pressaodiastolica.utils.NumberUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PressaoDiastolicaService {

	private static final Double PRESSAO_MIN = 80.0;
	private static final Double PRESSAO_MAX = 90.0;

	public AgentePressaoDiastolica calcularResultado(AgentePressaoDiastolica agente) {
		Double resultado = (agente.getPressaoDiastolica() - PRESSAO_MIN) / (PRESSAO_MAX - PRESSAO_MIN);
		agente.setResultado(NumberUtils.limitToInterval(resultado, 0.0, 1.0));
		return agente;
	}

}

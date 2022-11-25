package br.com.ifes.com.smarc.sedentarismo.service;

import br.com.ifes.com.smarc.sedentarismo.domain.entities.AgenteSedentarismo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class SedentarismoService {

	public AgenteSedentarismo calcularResultado(AgenteSedentarismo agenteSedentarismo) {
		switch (agenteSedentarismo.getFrequenciaAtividadeFisicaSemana()) {
			case 0:
				agenteSedentarismo.setResultado(1.0);
				break;
			case 1:
				agenteSedentarismo.setResultado(0.75);
				break;
			case 2:
				agenteSedentarismo.setResultado(0.5);
				break;
			case 3:
				agenteSedentarismo.setResultado(0.25);
				break;
			default:
				agenteSedentarismo.setResultado(0.0);
				break;
		}
		return agenteSedentarismo;
	}

}

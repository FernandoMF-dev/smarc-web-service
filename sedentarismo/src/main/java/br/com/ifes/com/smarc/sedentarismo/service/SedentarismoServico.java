package br.com.ifes.com.smarc.sedentarismo.service;

import br.com.ifes.com.smarc.sedentarismo.model.AgenteSedentarismoModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class SedentarismoServico {

	public AgenteSedentarismoModel calcularResultado(AgenteSedentarismoModel agenteSedentarismoModel) {
		switch (agenteSedentarismoModel.getFrequenciaAtividadeFisicaSemana()) {
			case 0:
				agenteSedentarismoModel.setResultado(1.0);
				break;
			case 1:
				agenteSedentarismoModel.setResultado(0.75);
				break;
			case 2:
				agenteSedentarismoModel.setResultado(0.5);
				break;
			case 3:
				agenteSedentarismoModel.setResultado(0.25);
				break;
			default:
				agenteSedentarismoModel.setResultado(0.0);
				break;
		}
		return agenteSedentarismoModel;
	}

}

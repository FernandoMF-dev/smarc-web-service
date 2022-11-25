package br.com.ifes.com.smarc.servico.service;

import br.com.ifes.com.smarc.servico.domain.entities.AgenteObesidade;
import br.com.ifes.com.smarc.servico.domain.entities.AgentePressaoSistolica;
import br.com.ifes.com.smarc.servico.domain.entities.AgenteSedentarismo;
import br.com.ifes.com.smarc.servico.domain.entities.AgenteTabagismo;
import br.com.ifes.com.smarc.servico.web.client.ObesidadeClient;
import br.com.ifes.com.smarc.servico.web.client.PressaoSistolicaClient;
import br.com.ifes.com.smarc.servico.web.client.SedentarismoClient;
import br.com.ifes.com.smarc.servico.web.client.TabagismoClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class SmarcService {

	private final ObesidadeClient obesidadeClient;

	private final SedentarismoClient sedentarismoClient;

	private final TabagismoClient tabagismoClient;

	private final PressaoSistolicaClient pressaoSistolicaClient;

	public AgenteObesidade resultadoAgenteObesidade(AgenteObesidade agenteObesidade) {
		return obesidadeClient.calcularResultado(agenteObesidade);
	}

	public AgenteSedentarismo resultadoAgenteSedentarismo(AgenteSedentarismo agenteSedentarismo) {
		return sedentarismoClient.calcularResultado(agenteSedentarismo);
	}

	public AgenteTabagismo resultadoAgenteTabagismo(AgenteTabagismo agenteTabagismo) {
		return tabagismoClient.calcularResultado(agenteTabagismo);
	}

	public AgentePressaoSistolica resultadoAgentePressaoSistolica(AgentePressaoSistolica agentePressaoSistolica) {
		return pressaoSistolicaClient.calcularResultado(agentePressaoSistolica);
	}

}


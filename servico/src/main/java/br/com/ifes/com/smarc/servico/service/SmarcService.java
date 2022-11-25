package br.com.ifes.com.smarc.servico.service;

import br.com.ifes.com.smarc.servico.model.AgenteObesidadeModel;
import br.com.ifes.com.smarc.servico.model.AgentePressaoSistolica;
import br.com.ifes.com.smarc.servico.model.AgenteSedentarismoModel;
import br.com.ifes.com.smarc.servico.model.AgenteTabagismoModel;
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

	public void teste() {
		obesidadeClient.teste();
	}

	public AgenteObesidadeModel resultadoAgenteObesidade(AgenteObesidadeModel agenteObesidadeModel) {
		return obesidadeClient.calcularResultado(agenteObesidadeModel);
	}

	public AgenteSedentarismoModel resultadoAgenteSedentarismo(AgenteSedentarismoModel agenteSedentarismoModel) {
		return sedentarismoClient.calcularResultado(agenteSedentarismoModel);
	}

	public AgenteTabagismoModel resultadoAgenteTabagismo(AgenteTabagismoModel agenteTabagismoModel) {
		return tabagismoClient.calcularResultado(agenteTabagismoModel);
	}

	public AgentePressaoSistolica resultadoAgentePressaoSistolica(AgentePressaoSistolica agentePressaoSistolica) {
		return pressaoSistolicaClient.calcularResultado(agentePressaoSistolica);
	}

}


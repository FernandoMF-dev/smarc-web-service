package br.com.ifes.com.smarc.servico.service;

import br.com.ifes.com.smarc.servico.domain.entities.AgenteObesidade;
import br.com.ifes.com.smarc.servico.domain.entities.AgentePressaoDiastolica;
import br.com.ifes.com.smarc.servico.domain.entities.AgentePressaoSistolica;
import br.com.ifes.com.smarc.servico.domain.entities.AgenteSedentarismo;
import br.com.ifes.com.smarc.servico.domain.entities.AgenteTabagismo;
import br.com.ifes.com.smarc.servico.domain.entities.AvaliacaoInput;
import br.com.ifes.com.smarc.servico.domain.entities.AvaliacaoOutput;
import br.com.ifes.com.smarc.servico.domain.entities.ControleLpa2v;
import br.com.ifes.com.smarc.servico.web.client.ObesidadeClient;
import br.com.ifes.com.smarc.servico.web.client.PressaoDiastolicaClient;
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

	private static final Double PARAMETRO_CONTROLE = 0.6;

	private final ObesidadeClient obesidadeClient;
	private final SedentarismoClient sedentarismoClient;
	private final TabagismoClient tabagismoClient;
	private final PressaoSistolicaClient pressaoSistolicaClient;
	private final PressaoDiastolicaClient pressaoDiastolicaClient;

	public AvaliacaoOutput avaliarRiscoCardiologico(AvaliacaoInput input) {
		AvaliacaoOutput output = calcularIndicadoresRiscoCardiaco(input);
		ControleLpa2v lpa2v = calcularMaiorControleLpa2v(output);

		output.setGrauCerteza(lpa2v.getGrauCerteza());
		output.setGrauContradicao(lpa2v.getGrauContradicao());
		output.setAvaliacao(lpa2v.avaliar());

		return output;
	}

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

	public AgentePressaoDiastolica resultadoAgentePressaoDiastolica(AgentePressaoDiastolica agentePressaoDiastolica) {
		return pressaoDiastolicaClient.calcularResultado(agentePressaoDiastolica);
	}

	private AvaliacaoOutput calcularIndicadoresRiscoCardiaco(AvaliacaoInput input) {
		AvaliacaoOutput output = new AvaliacaoOutput();
		output.setObesidade(resultadoAgenteObesidade(input.getAgenteObesidade()).getResultado());
		output.setSedentarismo(resultadoAgenteSedentarismo(input.getAgenteSedentarismo()).getResultado());
		output.setTabagismo(resultadoAgenteTabagismo(input.getAgenteTabagismo()).getResultado());
		output.setPressaoSistolica(resultadoAgentePressaoSistolica(input.getAgentePressaoSistolica()).getResultado());
		output.setPressaoDiastolica(resultadoAgentePressaoDiastolica(input.getAgentePressaoDiastolica()).getResultado());
		return output;
	}

	private ControleLpa2v calcularMaiorControleLpa2v(AvaliacaoOutput indicadores) {
		ControleLpa2v c1 = new ControleLpa2v(indicadores.getObesidade(), indicadores.getPressaoSistolica(), PARAMETRO_CONTROLE);
		ControleLpa2v c2 = new ControleLpa2v(indicadores.getPressaoSistolica(), indicadores.getPressaoDiastolica(), PARAMETRO_CONTROLE);
		ControleLpa2v c3 = new ControleLpa2v(indicadores.getSedentarismo(), indicadores.getTabagismo(), PARAMETRO_CONTROLE);

		ControleLpa2v c4 = new ControleLpa2v(c1, c2);

		return new ControleLpa2v(c3, c4);
	}

}


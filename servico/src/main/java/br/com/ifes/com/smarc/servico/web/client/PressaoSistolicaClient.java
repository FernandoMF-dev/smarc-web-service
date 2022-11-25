package br.com.ifes.com.smarc.servico.web.client;

import br.com.ifes.com.smarc.servico.domain.entities.AgentePressaoSistolica;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "pressao-sistolica", path = "/api/pressao-sistolica", url = "${application.module.pressaosistolica}")
public interface PressaoSistolicaClient {

	@PostMapping()
	AgentePressaoSistolica calcularResultado(AgentePressaoSistolica agentePressaoSistolica);

}

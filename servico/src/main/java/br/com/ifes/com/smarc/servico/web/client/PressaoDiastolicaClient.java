package br.com.ifes.com.smarc.servico.web.client;

import br.com.ifes.com.smarc.servico.domain.entities.AgentePressaoDiastolica;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "pressaodiastolica", path = "/api/pressaodiastolica", url = "${application.module.pressaodiastolica}")
public interface PressaoDiastolicaClient {

	@PostMapping()
	AgentePressaoDiastolica calcularResultado(AgentePressaoDiastolica agentePressaoSistolica);

}

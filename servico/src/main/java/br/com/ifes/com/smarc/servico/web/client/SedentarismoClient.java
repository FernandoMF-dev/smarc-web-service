package br.com.ifes.com.smarc.servico.web.client;

import br.com.ifes.com.smarc.servico.model.AgenteSedentarismoModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "sedentarismo", path = "/api/sedentarismo", url = "${application.module.sedentarismo}")
public interface SedentarismoClient {

	@PostMapping()
	AgenteSedentarismoModel calcularResultado(AgenteSedentarismoModel agenteSedentarismoModel);

}

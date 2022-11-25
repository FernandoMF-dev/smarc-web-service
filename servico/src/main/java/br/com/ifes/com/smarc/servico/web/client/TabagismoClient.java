package br.com.ifes.com.smarc.servico.web.client;

import br.com.ifes.com.smarc.servico.domain.entities.AgenteTabagismo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "tabagismo", path = "/api/tabagismo", url = "${application.module.tabagismo}")
public interface TabagismoClient {

	@PostMapping()
	AgenteTabagismo calcularResultado(AgenteTabagismo agenteTabagismo);

}

package br.com.ifes.com.smarc.servico.web.client;

import br.com.ifes.com.smarc.servico.model.AgenteTabagismoModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "tabagismo", path = "/api/tabagismo", url = "${application.module.tabagismo}")
public interface TabagismoClient {

	@PostMapping()
	AgenteTabagismoModel calcularResultado(AgenteTabagismoModel agenteTabagismoModel);

}

package br.com.ifes.com.smarc.servico.web.client;

import br.com.ifes.com.smarc.servico.domain.entities.AgenteObesidade;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "obesidade", path = "/api/obesidade", url = "${application.module.obesidade}")
public interface ObesidadeClient {

	@PostMapping()
	AgenteObesidade calcularResultado(AgenteObesidade agenteObesidade);

}

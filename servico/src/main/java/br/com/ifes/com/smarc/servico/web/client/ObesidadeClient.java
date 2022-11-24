package br.com.ifes.com.smarc.servico.web.client;

import br.com.ifes.com.smarc.servico.model.AgenteObesidadeModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "obesidade", path = "/api/obesidade", url = "${application.module.obesidade}")
public interface ObesidadeClient {

	@GetMapping()
	void teste();

	@PostMapping()
	AgenteObesidadeModel calcularResultado(AgenteObesidadeModel agenteObesidadeModel);

}

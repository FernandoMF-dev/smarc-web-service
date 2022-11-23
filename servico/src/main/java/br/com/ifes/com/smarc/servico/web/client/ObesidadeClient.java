package br.com.ifes.com.smarc.servico.web.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "obesidade", path = "/api/obesidade", url = "${application.module.obesidade}")
public interface ObesidadeClient {

	@GetMapping()
	void teste();

}

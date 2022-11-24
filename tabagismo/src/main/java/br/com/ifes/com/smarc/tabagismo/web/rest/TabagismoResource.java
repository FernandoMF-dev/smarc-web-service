package br.com.ifes.com.smarc.tabagismo.web.rest;

import br.com.ifes.com.smarc.tabagismo.model.AgenteTabagismoModel;
import br.com.ifes.com.smarc.tabagismo.service.TabagismoServico;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tabagismo")
public class TabagismoResource {

	private final TabagismoServico tabagismoServico;

	@PostMapping
	public ResponseEntity<AgenteTabagismoModel> calcularResultado(@RequestBody AgenteTabagismoModel agenteTabagismoModel) {
		log.info("Agente de Tabagismo: Calculando resultado...");
		return ResponseEntity.status(HttpStatus.OK).body(tabagismoServico.calcularResultado(agenteTabagismoModel));
	}

}

package br.com.ifes.com.smarc.tabagismo.web.rest;

import br.com.ifes.com.smarc.tabagismo.domain.entities.AgenteTabagismo;
import br.com.ifes.com.smarc.tabagismo.service.TabagismoService;
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

	private final TabagismoService tabagismoService;

	@PostMapping
	public ResponseEntity<AgenteTabagismo> calcularResultado(@RequestBody AgenteTabagismo agenteTabagismo) {
		log.info("Agente de Tabagismo: Requisição para calcular o indicador de risco de tabagismo.");
		return ResponseEntity.status(HttpStatus.OK).body(tabagismoService.calcularResultado(agenteTabagismo));
	}

}

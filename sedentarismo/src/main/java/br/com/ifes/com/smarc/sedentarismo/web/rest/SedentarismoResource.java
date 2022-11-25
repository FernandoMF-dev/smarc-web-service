package br.com.ifes.com.smarc.sedentarismo.web.rest;

import br.com.ifes.com.smarc.sedentarismo.domain.entities.AgenteSedentarismo;
import br.com.ifes.com.smarc.sedentarismo.service.SedentarismoService;
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
@RequestMapping("/api/sedentarismo")
public class SedentarismoResource {

	private final SedentarismoService sedentarismoService;

	@PostMapping
	public ResponseEntity<AgenteSedentarismo> calcularResultado(@RequestBody AgenteSedentarismo agenteSedentarismo) {
		log.info("Agente de Sedentarismo: Calculando resultado...");
		return ResponseEntity.status(HttpStatus.OK).body(sedentarismoService.calcularResultado(agenteSedentarismo));
	}

}

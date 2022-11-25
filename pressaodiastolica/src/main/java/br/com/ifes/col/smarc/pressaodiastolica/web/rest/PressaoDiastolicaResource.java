package br.com.ifes.col.smarc.pressaodiastolica.web.rest;

import br.com.ifes.col.smarc.pressaodiastolica.domain.entities.AgentePressaoDiastolica;
import br.com.ifes.col.smarc.pressaodiastolica.service.PressaoDiastolicaService;
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
@RequestMapping("/api/pressao-diastolica")
public class PressaoDiastolicaResource {

	private final PressaoDiastolicaService pressaoDiastolicaService;

	@PostMapping
	public ResponseEntity<AgentePressaoDiastolica> calcularResultado(@RequestBody AgentePressaoDiastolica agentePressaoSistolica) {
		log.info("Requisição para calcular resultado da pressão diastólica");
		return ResponseEntity.status(HttpStatus.OK).body(pressaoDiastolicaService.calcularResultado(agentePressaoSistolica));
	}

}

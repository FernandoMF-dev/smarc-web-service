package br.com.ifes.com.smarc.pressaosistolica.web.rest;

import br.com.ifes.com.smarc.pressaosistolica.domain.entities.AgentePressaoSistolica;
import br.com.ifes.com.smarc.pressaosistolica.service.PressaoSistolicaService;
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
@RequestMapping("/api/pressao-sistolica")
public class PressaoSistolicaResource {

	private final PressaoSistolicaService pressaoSistolicaService;

	@PostMapping
	public ResponseEntity<AgentePressaoSistolica> calcularResultado(@RequestBody AgentePressaoSistolica agentePressaoSistolica) {
		log.info("Agente de Pressão Sistólica: Requisição para calcular o indicador de risco de alta pressão sistólica.");
		return ResponseEntity.status(HttpStatus.OK).body(pressaoSistolicaService.calcularResultado(agentePressaoSistolica));
	}

}

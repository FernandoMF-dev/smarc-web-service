package br.com.ifes.com.smarc.servico.web.rest;

import br.com.ifes.com.smarc.servico.model.AgenteObesidadeModel;
import br.com.ifes.com.smarc.servico.model.AgenteSedentarismoModel;
import br.com.ifes.com.smarc.servico.service.SmarcService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/smarc")
public class SmarcResource {

	private final SmarcService smarcService;

	@GetMapping
	public ResponseEntity<Void> teste() {
		log.info("Requisição TESTE");
		smarcService.teste();
		return ResponseEntity.ok().build();
	}

	@PostMapping("/obesidade")
	public ResponseEntity<AgenteObesidadeModel> agenteObesidade(@Valid @RequestBody AgenteObesidadeModel agenteObesidadeModel) {
		log.info("SMARC: Mandando informações para o Agente de Obesidade...");
		return ResponseEntity.status(HttpStatus.OK).body(smarcService.resultadoAgenteObesidade(agenteObesidadeModel));
	}

	@PostMapping("/sedentarismo")
	public ResponseEntity<AgenteSedentarismoModel> agenteSedentarismo(@Valid @RequestBody AgenteSedentarismoModel agenteSedentarismoModel) {
		log.info("SMARC: Mandando informações para o Agente de Sedentarismo...");
		return ResponseEntity.status(HttpStatus.OK).body(smarcService.resultadoAgenteSedentarismo(agenteSedentarismoModel));
	}

}

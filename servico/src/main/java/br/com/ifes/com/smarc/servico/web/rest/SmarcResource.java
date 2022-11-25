package br.com.ifes.com.smarc.servico.web.rest;

import br.com.ifes.com.smarc.servico.domain.entities.AgenteObesidade;
import br.com.ifes.com.smarc.servico.domain.entities.AgentePressaoDiastolica;
import br.com.ifes.com.smarc.servico.domain.entities.AgentePressaoSistolica;
import br.com.ifes.com.smarc.servico.domain.entities.AgenteSedentarismo;
import br.com.ifes.com.smarc.servico.domain.entities.AgenteTabagismo;
import br.com.ifes.com.smarc.servico.domain.entities.AvaliacaoInput;
import br.com.ifes.com.smarc.servico.domain.entities.AvaliacaoOutput;
import br.com.ifes.com.smarc.servico.service.SmarcService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	@PostMapping()
	public ResponseEntity<AvaliacaoOutput> avaliarRiscoCardiologico(@Valid @RequestBody AvaliacaoInput input) {
		log.info("SMARC: Requisição para avaliar risco cardiológico com base no algorítmo para-analisador da LPA2v.");
		return ResponseEntity.status(HttpStatus.OK).body(smarcService.avaliarRiscoCardiologico(input));
	}

	@PostMapping("/obesidade")
	public ResponseEntity<AgenteObesidade> agenteObesidade(@Valid @RequestBody AgenteObesidade agenteObesidade) {
		log.info("SMARC: Requisição para calcular o indicador de risco de obesidade grave.");
		return ResponseEntity.status(HttpStatus.OK).body(smarcService.resultadoAgenteObesidade(agenteObesidade));
	}

	@PostMapping("/sedentarismo")
	public ResponseEntity<AgenteSedentarismo> agenteSedentarismo(@Valid @RequestBody AgenteSedentarismo agenteSedentarismo) {
		log.info("SMARC: Requisição para calcular o indicador de risco de sedentarismo.");
		return ResponseEntity.status(HttpStatus.OK).body(smarcService.resultadoAgenteSedentarismo(agenteSedentarismo));
	}

	@PostMapping("/tabagismo")
	public ResponseEntity<AgenteTabagismo> agenteTabagismo(@Valid @RequestBody AgenteTabagismo agenteTabagismo) {
		log.info("SMARC: Requisição para calcular o indicador de risco de tabagismo.");
		return ResponseEntity.status(HttpStatus.OK).body(smarcService.resultadoAgenteTabagismo(agenteTabagismo));
	}

	@PostMapping("/pressao-sistolica")
	public ResponseEntity<AgentePressaoSistolica> agentePressaoSistolica(@Valid @RequestBody AgentePressaoSistolica agentePressaoSistolica) {
		log.info("SMARC: Requisição para calcular o indicador de risco de alta pressão sistólica.");
		return ResponseEntity.status(HttpStatus.OK).body(smarcService.resultadoAgentePressaoSistolica(agentePressaoSistolica));
	}

	@PostMapping("/pressao-diastolica")
	public ResponseEntity<AgentePressaoDiastolica> agentePressaoSistolica(@Valid @RequestBody AgentePressaoDiastolica agentePressaoDiastolica) {
		log.info("SMARC: Requisição para calcular o indicador de risco de alta pressão diastólica.");
		return ResponseEntity.status(HttpStatus.OK).body(smarcService.resultadoAgentePressaoDiastolica(agentePressaoDiastolica));
	}

}

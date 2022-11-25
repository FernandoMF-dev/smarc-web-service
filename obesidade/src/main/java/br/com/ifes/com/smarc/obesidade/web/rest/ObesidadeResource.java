package br.com.ifes.com.smarc.obesidade.web.rest;

import br.com.ifes.com.smarc.obesidade.domain.entities.AgenteObesidade;
import br.com.ifes.com.smarc.obesidade.service.ObesidadeService;
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
@RequestMapping("/api/obesidade")
public class ObesidadeResource {

	private final ObesidadeService obesidadeService;

	@PostMapping
	public ResponseEntity<AgenteObesidade> calcularResultado(@RequestBody AgenteObesidade agenteObesidade) {
		log.info("Agente de Obesidade: Requisição para calcular o indicador de risco de obesidade grave.");
		return ResponseEntity.status(HttpStatus.OK).body(obesidadeService.calcularResultado(agenteObesidade));
	}

}

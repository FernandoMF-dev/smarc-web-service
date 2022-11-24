package br.com.ifes.com.smarc.obesidade.web.rest;

import br.com.ifes.com.smarc.obesidade.model.AgenteObesidadeModel;
import br.com.ifes.com.smarc.obesidade.service.ObesidadeServico;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/obesidade")
public class ObesidadeResource {

	private final ObesidadeServico obesidadeServico;

	@GetMapping
	public ResponseEntity<Void> teste() {
		log.info("Requisição TESTE");
		obesidadeServico.teste();
		return ResponseEntity.ok().build();
	}

	@PostMapping
	public ResponseEntity<AgenteObesidadeModel> calcularResultado(@RequestBody AgenteObesidadeModel agenteObesidadeModel) {
		log.info("Agente de Obesidade: Calculando resultado...");
		return ResponseEntity.status(HttpStatus.OK).body(obesidadeServico.calcularResultado(agenteObesidadeModel));
	}

}

package br.com.ifes.com.smarc.obesidade.web.rest;

import br.com.ifes.com.smarc.obesidade.service.ObesidadeServico;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

}

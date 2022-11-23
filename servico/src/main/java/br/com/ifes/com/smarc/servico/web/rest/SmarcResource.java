package br.com.ifes.com.smarc.servico.web.rest;

import br.com.ifes.com.smarc.servico.service.SmarcService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}

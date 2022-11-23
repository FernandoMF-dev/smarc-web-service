package br.com.ifes.com.smarc.servico.service;

import br.com.ifes.com.smarc.servico.web.client.ObesidadeClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class SmarcService {

	private final ObesidadeClient obesidadeClient;

	public void teste() {
		obesidadeClient.teste();
	}

}


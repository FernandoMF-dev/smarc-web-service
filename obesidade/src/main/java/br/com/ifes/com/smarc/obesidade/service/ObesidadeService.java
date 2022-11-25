package br.com.ifes.com.smarc.obesidade.service;

import br.com.ifes.com.smarc.obesidade.domain.entities.AgenteObesidade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ObesidadeService {

	public AgenteObesidade calcularResultado(AgenteObesidade agenteObesidade) {
		calcularImc(agenteObesidade);
		if (agenteObesidade.getImc() <= 25) {
			agenteObesidade.setResultado(0.0);
			return agenteObesidade;
		}

		if (agenteObesidade.getImc() >= 40) {
			agenteObesidade.setResultado(1.0);
			return agenteObesidade;
		}

		agenteObesidade.setResultado((agenteObesidade.getImc() - 25) / (40 - 25));
		return agenteObesidade;
	}

	private void calcularImc(AgenteObesidade agenteObesidade) {
		agenteObesidade.setImc(agenteObesidade.getPeso() / (agenteObesidade.getAltura() * 2));
	}

}

package br.com.ifes.com.smarc.obesidade.service;

import br.com.ifes.com.smarc.obesidade.domain.entities.AgenteObesidade;
import br.com.ifes.com.smarc.obesidade.utils.NumberUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ObesidadeService {

	private static final Double IMC_MIN = 25.0;
	private static final Double IMC_MAX = 40.0;

	public AgenteObesidade calcularResultado(AgenteObesidade agenteObesidade) {
		calcularImc(agenteObesidade);
		Double resultado = (agenteObesidade.getImc() - IMC_MIN) / (IMC_MAX - IMC_MIN);
		agenteObesidade.setResultado(NumberUtils.limitToInterval(resultado, 0.0, 1.0));
		return agenteObesidade;
	}

	private void calcularImc(AgenteObesidade agenteObesidade) {
		agenteObesidade.setImc(agenteObesidade.getPeso() / (agenteObesidade.getAltura() * 2));
	}

}

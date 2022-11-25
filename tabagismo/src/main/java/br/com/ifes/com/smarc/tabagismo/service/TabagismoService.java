package br.com.ifes.com.smarc.tabagismo.service;

import br.com.ifes.com.smarc.tabagismo.domain.entities.AgenteTabagismo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class TabagismoService {

	private void calcularTotalPontos(AgenteTabagismo agenteTabagismo) {
		Integer totalPontos = 0;

		if (agenteTabagismo.getMinutosAposAcordarPrimeiroCigarro() > 0 && agenteTabagismo.getMinutosAposAcordarPrimeiroCigarro() <= 5) {
			totalPontos = 3;
		}

		if (agenteTabagismo.getMinutosAposAcordarPrimeiroCigarro() > 5 && agenteTabagismo.getMinutosAposAcordarPrimeiroCigarro() <= 30) {
			totalPontos = 2;
		}

		if (agenteTabagismo.getMinutosAposAcordarPrimeiroCigarro() > 30 && agenteTabagismo.getMinutosAposAcordarPrimeiroCigarro() <= 60) {
			totalPontos = 1;
		}

		if (agenteTabagismo.getDificilNaoFumarLocaisProibidos()) {
			totalPontos++;
		}

		if (agenteTabagismo.getQualCigarroDoDiaDaMaisSatisfacao() == 1) {
			totalPontos++;
		}

		if (agenteTabagismo.getQuantosCigarrosFumaDiariamente() > 10 && agenteTabagismo.getQuantosCigarrosFumaDiariamente() <= 20) {
			totalPontos++;
		}

		if (agenteTabagismo.getQuantosCigarrosFumaDiariamente() > 20 && agenteTabagismo.getQuantosCigarrosFumaDiariamente() <= 30) {
			totalPontos = totalPontos + 2;
		}

		if (agenteTabagismo.getQuantosCigarrosFumaDiariamente() > 30) {
			totalPontos = totalPontos + 3;
		}

		if (agenteTabagismo.getFumaMaisfrequenteManha()) {
			totalPontos++;
		}

		if (agenteTabagismo.getFumaMesmoDoente()) {
			totalPontos++;
		}

		agenteTabagismo.setTotalPontos(totalPontos);

	}

	public AgenteTabagismo calcularResultado(AgenteTabagismo agenteTabagismo) {
		calcularTotalPontos(agenteTabagismo);
		if (agenteTabagismo.getTotalPontos() == 0) {
			agenteTabagismo.setResultado(0.0);
		} else if (agenteTabagismo.getTotalPontos() <= 3) {
			agenteTabagismo.setResultado(0.25);
		} else if (agenteTabagismo.getTotalPontos() <= 5) {
			agenteTabagismo.setResultado(0.5);
		} else if (agenteTabagismo.getTotalPontos() <= 8) {
			agenteTabagismo.setResultado(0.75);
		} else {
			agenteTabagismo.setResultado(1.0);
		}

		return agenteTabagismo;
	}

}

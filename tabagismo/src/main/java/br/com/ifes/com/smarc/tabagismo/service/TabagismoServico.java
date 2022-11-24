package br.com.ifes.com.smarc.tabagismo.service;

import br.com.ifes.com.smarc.tabagismo.model.AgenteTabagismoModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class TabagismoServico {

	private void calcularTotalPontos(AgenteTabagismoModel agenteTabagismoModel) {
		Integer totalPontos = 0;

		if (agenteTabagismoModel.getMinutosAposAcordarPrimeiroCigarro() > 0 && agenteTabagismoModel.getMinutosAposAcordarPrimeiroCigarro() <= 5) {
			totalPontos = 3;
		}

		if (agenteTabagismoModel.getMinutosAposAcordarPrimeiroCigarro() > 5 && agenteTabagismoModel.getMinutosAposAcordarPrimeiroCigarro() <= 30) {
			totalPontos = 2;
		}

		if (agenteTabagismoModel.getMinutosAposAcordarPrimeiroCigarro() > 30 && agenteTabagismoModel.getMinutosAposAcordarPrimeiroCigarro() <= 60) {
			totalPontos = 1;
		}

		if (agenteTabagismoModel.getDificilNaoFumarLocaisProibidos()) {
			totalPontos++;
		}

		if (agenteTabagismoModel.getQualCigarroDoDiaDaMaisSatisfacao() == 1) {
			totalPontos++;
		}

		if (agenteTabagismoModel.getQuantosCigarrosFumaDiariamente() > 10 && agenteTabagismoModel.getQuantosCigarrosFumaDiariamente() <= 20) {
			totalPontos++;
		}

		if (agenteTabagismoModel.getQuantosCigarrosFumaDiariamente() > 20 && agenteTabagismoModel.getQuantosCigarrosFumaDiariamente() <= 30) {
			totalPontos = totalPontos + 2;
		}

		if (agenteTabagismoModel.getQuantosCigarrosFumaDiariamente() > 30) {
			totalPontos = totalPontos + 3;
		}

		if (agenteTabagismoModel.getFumaMaisfrequenteManha()) {
			totalPontos++;
		}

		if (agenteTabagismoModel.getFumaMesmoDoente()) {
			totalPontos++;
		}

		agenteTabagismoModel.setTotalPontos(totalPontos);

	}

	public AgenteTabagismoModel calcularResultado(AgenteTabagismoModel agenteTabagismoModel) {
		calcularTotalPontos(agenteTabagismoModel);
		if (agenteTabagismoModel.getTotalPontos() == 0) {
			agenteTabagismoModel.setResultado(0.0);
		} else if (agenteTabagismoModel.getTotalPontos() <= 3) {
			agenteTabagismoModel.setResultado(0.25);
		} else if (agenteTabagismoModel.getTotalPontos() <= 5) {
			agenteTabagismoModel.setResultado(0.5);
		} else if (agenteTabagismoModel.getTotalPontos() <= 8) {
			agenteTabagismoModel.setResultado(0.75);
		} else {
			agenteTabagismoModel.setResultado(1.0);
		}

		return agenteTabagismoModel;
	}

}

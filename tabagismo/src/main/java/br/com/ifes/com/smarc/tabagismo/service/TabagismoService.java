package br.com.ifes.com.smarc.tabagismo.service;

import br.com.ifes.com.smarc.tabagismo.domain.entities.AgenteTabagismo;
import br.com.ifes.com.smarc.tabagismo.domain.enums.PontosCigarrosDiariosEnum;
import br.com.ifes.com.smarc.tabagismo.domain.enums.PontosPrimeiroCigarroEnum;
import br.com.ifes.com.smarc.tabagismo.domain.enums.PontosTabagismoEnum;
import br.com.ifes.com.smarc.tabagismo.utils.ConversionUtils;
import br.com.ifes.com.smarc.tabagismo.utils.NumberUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.stream.Stream;

@Service
@Transactional
@RequiredArgsConstructor
public class TabagismoService {

	public AgenteTabagismo calcularResultado(AgenteTabagismo agenteTabagismo) {
		calcularTotalPontos(agenteTabagismo);
		calcularResultadoTabagismo(agenteTabagismo);

		return agenteTabagismo;
	}

	private void calcularResultadoTabagismo(AgenteTabagismo agenteTabagismo) {
		PontosTabagismoEnum pontos = Stream.of(PontosTabagismoEnum.values())
				.filter(value -> agenteTabagismo.getTotalPontos() <= value.getPontosMax())
				.findFirst().orElse(null);

		if (Objects.isNull(pontos)) {
			agenteTabagismo.setResultado(PontosTabagismoEnum.PONTUACAO_PADRAO);
		} else {
			agenteTabagismo.setResultado(pontos.getPontuacao());
		}
	}

	private void calcularTotalPontos(AgenteTabagismo agenteTabagismo) {
		int totalPontos = calcularPontosPrimeiroCigarro(agenteTabagismo.getMinutosAposAcordarPrimeiroCigarro());
		totalPontos += calcularPontosCigarrosDiarios(agenteTabagismo.getQuantosCigarrosFumaDiariamente());
		totalPontos += ConversionUtils.booleanToInteger(agenteTabagismo.getDificilNaoFumarLocaisProibidos());
		totalPontos += ConversionUtils.booleanToInteger(agenteTabagismo.getFumaMaisfrequenteManha());
		totalPontos += ConversionUtils.booleanToInteger(agenteTabagismo.getFumaMesmoDoente());
		totalPontos += ConversionUtils.booleanToInteger(agenteTabagismo.getQualCigarroDoDiaDaMaisSatisfacao() == 1);

		agenteTabagismo.setTotalPontos(totalPontos);
	}

	private Integer calcularPontosPrimeiroCigarro(Integer minutos) {
		PontosPrimeiroCigarroEnum pontos = Stream.of(PontosPrimeiroCigarroEnum.values())
				.filter(value -> NumberUtils.isInBetween(minutos, value.getMinutosMin(), value.getMinutosMax()))
				.findFirst().orElse(null);

		if (Objects.isNull(pontos)) {
			return PontosPrimeiroCigarroEnum.PONTUACAO_PADRAO;
		}
		return pontos.getPontuacao();
	}

	private Integer calcularPontosCigarrosDiarios(Integer cigarrosDiarios) {
		PontosCigarrosDiariosEnum pontos = Stream.of(PontosCigarrosDiariosEnum.values())
				.filter(value -> NumberUtils.isInBetween(cigarrosDiarios, value.getQuantidadeMin(), value.getQuantidadeMax()))
				.findFirst().orElse(null);

		if (Objects.isNull(pontos)) {
			return PontosCigarrosDiariosEnum.PONTUACAO_PADRAO;
		}
		return pontos.getPontuacao();
	}

}

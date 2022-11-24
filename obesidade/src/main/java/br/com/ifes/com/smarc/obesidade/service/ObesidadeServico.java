package br.com.ifes.com.smarc.obesidade.service;

import br.com.ifes.com.smarc.obesidade.model.AgenteObesidadeModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ObesidadeServico {

	public void teste() {
	}

	public void calcularImc(AgenteObesidadeModel agenteObesidadeModel) {
		agenteObesidadeModel.setImc(agenteObesidadeModel.getPeso() / (agenteObesidadeModel.getAltura() * 2));
	}

	public AgenteObesidadeModel calcularResultado(AgenteObesidadeModel agenteObesidadeModel) {
		calcularImc(agenteObesidadeModel);
		if (agenteObesidadeModel.getImc() <= 25) {
			agenteObesidadeModel.setResultado(0.0);
			return agenteObesidadeModel;
		}

		if (agenteObesidadeModel.getImc() >= 40) {
			agenteObesidadeModel.setResultado(1.0);
			return agenteObesidadeModel;
		}

		agenteObesidadeModel.setResultado((agenteObesidadeModel.getImc() - 25) / (40 - 25));
		return agenteObesidadeModel;
	}

}

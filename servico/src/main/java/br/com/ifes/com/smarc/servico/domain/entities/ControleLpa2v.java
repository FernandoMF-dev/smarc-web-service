package br.com.ifes.com.smarc.servico.domain.entities;

import br.com.ifes.com.smarc.servico.domain.enums.ResultadoAvaliacaoEnum;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.ObjectUtils;

import java.util.Objects;

@Getter
@Setter
public class ControleLpa2v {
	private static final String AVALIACAO_FORMAT = "%s --> %s";

	private Double parametroControle;
	private Double evidenciaFavoravel;
	private Double evidenciaDesfavoravel;

	private Double grauCerteza;
	private Double grauContradicao;

	public ControleLpa2v(Double parametroControle, Double evidenciaFavoravel, Double evidenciaDesfavoravel) {
		this.parametroControle = parametroControle;
		this.evidenciaFavoravel = evidenciaFavoravel;
		this.evidenciaDesfavoravel = 1 - evidenciaDesfavoravel;

		this.updateGrauCerteza();
		this.updateGrauContradicao();
	}

	public ControleLpa2v(ControleLpa2v c1, ControleLpa2v c2) {
		this.evidenciaFavoravel = Math.max(c1.getEvidenciaFavoravel(), c2.getEvidenciaFavoravel());
		this.evidenciaDesfavoravel = Math.min(c1.getEvidenciaDesfavoravel(), c2.getEvidenciaDesfavoravel());
		this.parametroControle = (c1.getParametroControle() + c2.getParametroControle()) / 2;

		this.updateGrauCerteza();
		this.updateGrauContradicao();
	}

	public void updateGrauCerteza() {
		if (Objects.isNull(getEvidenciaFavoravel()) || Objects.isNull(getEvidenciaDesfavoravel())) {
			setGrauCerteza(null);
		} else {
			setGrauCerteza(getEvidenciaFavoravel() - getEvidenciaDesfavoravel());
		}
	}

	public void updateGrauContradicao() {
		if (Objects.isNull(getEvidenciaFavoravel()) || Objects.isNull(getEvidenciaDesfavoravel())) {
			setGrauContradicao(null);
		} else {
			setGrauContradicao(getEvidenciaFavoravel() + getEvidenciaDesfavoravel() - 1);
		}
	}

	public String avaliar() {
		ResultadoAvaliacaoEnum extremo = ObjectUtils.firstNonNull(avaliarExtremoCerteza(), avaliarExtremoContradicao());
		if (Objects.nonNull(extremo)) {
			return extremo.getDescricao();
		}

		ResultadoAvaliacaoEnum certeza = avaliarCerteza();
		ResultadoAvaliacaoEnum contradicao = avaliarContradicao();

		if (isConfiavel()) {
			return String.format(AVALIACAO_FORMAT, certeza.getDescricao(), contradicao.getDescricao());
		}
		return String.format(AVALIACAO_FORMAT, contradicao.getDescricao(), certeza.getDescricao());
	}

	public boolean isConfiavel() {
		return getGrauCerteza() >= getGrauContradicao();
	}

	public Double getValorSuperiorControleCerteza() {
		return getParametroControle();
	}

	public Double getValorSuperiorControleContradicao() {
		return getParametroControle();
	}

	public Double getValorInferiorControleCerteza() {
		return -getParametroControle();
	}

	public Double getValorInferiorControleContradicao() {
		return -getParametroControle();
	}

	private ResultadoAvaliacaoEnum avaliarExtremoCerteza() {
		ResultadoAvaliacaoEnum avaliacao = null;

		if (getGrauCerteza() >= getValorSuperiorControleCerteza()) {
			avaliacao = ResultadoAvaliacaoEnum.VERDADEIRO;
		}

		if (getGrauCerteza() <= getValorInferiorControleCerteza()) {
			avaliacao = ResultadoAvaliacaoEnum.FALSO;
		}

		return avaliacao;
	}

	private ResultadoAvaliacaoEnum avaliarExtremoContradicao() {
		ResultadoAvaliacaoEnum avaliacao = null;

		if (getGrauContradicao() >= getValorSuperiorControleContradicao()) {
			avaliacao = ResultadoAvaliacaoEnum.INCONSISTENTE;
		}

		if (getGrauContradicao() <= getValorInferiorControleContradicao()) {
			avaliacao = ResultadoAvaliacaoEnum.INDETERMINADO;
		}

		return avaliacao;
	}

	private ResultadoAvaliacaoEnum avaliarCerteza() {
		if (getGrauCerteza() > 0) {
			return isConfiavel() ? ResultadoAvaliacaoEnum.VERDADEIRO : ResultadoAvaliacaoEnum.QUASE_VERDADEIRO;
		}
		return isConfiavel() ? ResultadoAvaliacaoEnum.FALSO : ResultadoAvaliacaoEnum.QUASE_FALSO;
	}

	private ResultadoAvaliacaoEnum avaliarContradicao() {
		return getGrauContradicao() > 0 ? ResultadoAvaliacaoEnum.INCONSISTENTE : ResultadoAvaliacaoEnum.INDETERMINADO;
	}
}

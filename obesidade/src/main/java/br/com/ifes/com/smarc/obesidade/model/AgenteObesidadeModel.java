package br.com.ifes.com.smarc.obesidade.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AgenteObesidadeModel implements Serializable {

	private Double altura;

	private Double peso;

	private Double imc;

	private Double resultado;

}

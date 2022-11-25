package br.com.ifes.com.smarc.pressaosistolica.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class NumberUtils {

	public static Double limitToInterval(Double value, Double min, Double max) {
		return Math.min(Math.max(value, min), max);
	}

}

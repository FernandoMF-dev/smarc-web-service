package br.com.ifes.com.smarc.tabagismo.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class NumberUtils {

	public static Boolean isInBetween(Integer value, Integer min, Integer max) {
		return value > min && value <= max;
	}

}

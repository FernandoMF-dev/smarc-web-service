package br.com.ifes.com.smarc.tabagismo.utils;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.BooleanUtils;

@UtilityClass
public class ConversionUtils {

	public static Integer booleanToInteger(Boolean condicao) {
		return BooleanUtils.isTrue(condicao) ? 1 : 0;
	}

}

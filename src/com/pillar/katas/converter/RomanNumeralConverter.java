package com.pillar.katas.converter;

public class RomanNumeralConverter implements IConverterControl {

	@Override
	public String convertTo(int i) throws NotARomanNumeralException {
		return "I";
	}

}

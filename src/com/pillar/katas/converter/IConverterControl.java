package com.pillar.katas.converter;

public interface IConverterControl {

	/**
	 * 
	 * @param numericValue integer
	 * @return String roman numeral
	 * @throws NotARomanNumeralException
	 */
	String convertTo(int numericValue) throws NotARomanNumeralException;

}

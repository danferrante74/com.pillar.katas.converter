package com.pillar.katas.converter;

public interface IConverterControl {

	/**
	 * Returns a roman numeral for a numeric value < 3999 (max roman numeral)
	 * 
	 * @param numericValue integer
	 * @return String roman numeral
	 * @throws NotARomanNumeralException
	 */
	String convertTo(int numericValue) throws NotARomanNumeralException;

	/**
	 * Returns the numeric value for a VALID roman numeral.
	 * 
	 * @param roman numeral
	 * @return arabic numeric value
	 * @throws NotARomanNumeralException
	 */
	int convertFrom(String roman) throws NotARomanNumeralException;;

}

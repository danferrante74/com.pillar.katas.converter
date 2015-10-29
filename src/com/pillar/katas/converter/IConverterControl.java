package com.pillar.katas.converter;

public interface IConverterControl {

	/**
	 * Returns a roman numeral for a numeric value < 3999 (max roman numeral)
	 * 
	 * @param numericValue integer
	 * @return String converted value
	 * @throws NotAValidNumeralException
	 */
	String convertTo(int numericValue) throws NotAValidNumeralException;

	/**
	 * Returns the numeric value for a VALID roman numeral.
	 * 
	 * @param String value (roman numeral, other value to be converted)
	 * @return arabic numeric value
	 * @throws NotAValidNumeralException
	 */
	int convertFrom(String roman) throws NotAValidNumeralException;

}

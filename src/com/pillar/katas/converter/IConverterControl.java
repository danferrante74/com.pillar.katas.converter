package com.pillar.katas.converter;

public interface IConverterControl {

	/**
	 * 
	 * @param i
	 * @return
	 * @throws NotARomanNumeralException
	 */
	String convertTo(int i) throws NotARomanNumeralException;

}

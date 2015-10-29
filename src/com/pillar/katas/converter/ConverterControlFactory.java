package com.pillar.katas.converter;

public class ConverterControlFactory {

	/**
	 * Factory method to return possibility of different converters.
	 * 
	 * @param type enumerated type of converter... can go into xml along with class names at some point to load at runtime.
	 * @return IConverterControl control layer to handle the conversion.
	 */
	public IConverterControl getConverter(ConverterTypes type) {
		return new RomanNumeralConverter();
	}


}

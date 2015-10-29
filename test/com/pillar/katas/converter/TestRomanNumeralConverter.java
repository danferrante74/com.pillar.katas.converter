package com.pillar.katas.converter;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestRomanNumeralConverter {

	@Test
	public void whenPassInA1ValueGetRomanNumeralI()
	{
		IConverterControl controller = new ConverterControlFactory().getConverter(ConverterTypes.ROMAN);
		try
		{
			String romanNumeral = controller.convertTo( 1 );
			assertEquals( "I", romanNumeral );
		}
		catch( NotARomanNumeralException ex )
		{
			fail( "Value could not be represented as a roman numeral." );
		}
	}
}

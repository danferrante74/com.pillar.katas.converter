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
	
	@Test
	public void whenPassIn3GetRomanNumeral()
	{
		IConverterControl controller = new ConverterControlFactory().getConverter(ConverterTypes.ROMAN);
		try
		{
			String romanNumeral = controller.convertTo( 3 );
			System.out.println( romanNumeral );
			assertEquals( "III", romanNumeral );
		}
		catch( NotARomanNumeralException ex )
		{
			fail( "Value could not be represented as a roman numeral." );			
		}
	}
	

	@Test
	public void whenPassIn9GetRomanNumeral()
	{
		IConverterControl controller = new ConverterControlFactory().getConverter(ConverterTypes.ROMAN);
		try
		{
			String romanNumeral = controller.convertTo( 9 );
			System.out.println( romanNumeral );
			assertEquals( "IX", romanNumeral );
		}
		catch( NotARomanNumeralException ex )
		{
			fail( "Value could not be represented as a roman numeral." );			
		}
	}
	
	@Test
	public void whenPassIn1066ToGetRomanNumeral()
	{
		IConverterControl controller = new ConverterControlFactory().getConverter(ConverterTypes.ROMAN);
		try
		{
			String romanNumeral = controller.convertTo( 1066 );
			System.out.println( romanNumeral );
			assertEquals( "MLXVI", romanNumeral );
		}
		catch( NotARomanNumeralException ex )
		{
			fail( "Value could not be represented as a roman numeral." );			
		}
	}	
	
	@Test
	public void whenPassIn1989ToGetRomanNumeral()
	{
		IConverterControl controller = new ConverterControlFactory().getConverter(ConverterTypes.ROMAN);
		try
		{
			String romanNumeral = controller.convertTo( 1989 );
			System.out.println( romanNumeral );
			assertEquals( "MCMLXXXIX", romanNumeral );
		}
		catch( NotARomanNumeralException ex )
		{
			fail( "Value could not be represented as a roman numeral." );			
		}
	}
	
	@Test
	public void whenPassInAValueGreaterThanMaxRomanNumeral()
	{
		IConverterControl controller = new ConverterControlFactory().getConverter(ConverterTypes.ROMAN);
		try
		{
			controller.convertTo( 4000 );
			fail( "!!!YOU MESSED UP: There is no roman numeral that can be represented here!!!" );
		}
		catch( NotARomanNumeralException ex )
		{
			assertTrue( true );
		}
		
	}
	
	@Test
	public void whenPassInAValueLessThan0ToGetRomanNumeral()
	{
		IConverterControl controller = new ConverterControlFactory().getConverter(ConverterTypes.ROMAN);
		try
		{
			controller.convertTo( -4000 );
			fail( "!!!YOU MESSED UP: There is no roman numeral that can be represented here!!!" );
		}
		catch( NotARomanNumeralException ex )
		{
			assertTrue( true );
		}
		
	}	
	
	@Test
	public void whenPassInA0ToGetRomanNumeral()
	{
		IConverterControl controller = new ConverterControlFactory().getConverter(ConverterTypes.ROMAN);
		try
		{
			controller.convertTo( 0 );
			fail( "!!!YOU MESSED UP: There is no roman numeral that can be represented here!!!" );
		}
		catch( NotARomanNumeralException ex )
		{
			assertTrue( true );
		}		
	}	
}

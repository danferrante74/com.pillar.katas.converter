package com.pillar.katas.converter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.pillar.katas.converter.commands.ConvertFromCommand;
import com.pillar.katas.converter.commands.ConvertToCommand;
import com.pillar.katas.converter.commands.ConverterCommand;
import com.pillar.katas.converter.commands.ConverterExecutionException;
import com.pillar.katas.converter.commands.ConverterResult;

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
	
	@Test
	public void whenPassInARomanNumeralToGetNumericValue()
	{
		IConverterControl controller = new ConverterControlFactory().getConverter(ConverterTypes.ROMAN);
		try
		{
			int expectedValue = 2999;
			String roman = controller.convertTo(expectedValue);
			int value = controller.convertFrom( roman );
			assertEquals( expectedValue, value );
		}
		catch( NotARomanNumeralException ex )
		{
			fail( "Value is not a roman numeral." );			
		}
	}	
	
	
	@Test
	public void whenPassInAMixedCaseRomanNumeralToGetNumericValue()
	{
		IConverterControl controller = new ConverterControlFactory().getConverter(ConverterTypes.ROMAN);
		try
		{
			String roman = "McMlXxxIx";
			int expectedValue = 1989;
			int value = controller.convertFrom( roman );
			assertEquals( expectedValue, value );
		}
		catch( NotARomanNumeralException ex )
		{
			fail( "Value is not a roman numeral." );			
		}
	}
	
	@Test
	public void whenPassInARomanNumeralToExecutionCommand()
	{
		String roman = "MCMLXXXIX";
		ConverterCommand<Integer> c = new ConvertFromCommand( ConverterTypes.ROMAN, roman ); //convert from a roman numeral
		try
		{

			int expectedValue = 1989;
			c.execute();
			ConverterResult<Integer> result = c.getResult();
			assertEquals( expectedValue, result.getResult().intValue() );
		}
		catch( ConverterExecutionException ex )
		{
			fail( "Value is not a roman numeral." );			
		}
	}
	
	@Test
	public void whenPassInANumericValueToExecutionCommand()
	{
		int numeric = 1066;
		ConverterCommand<String> c = new ConvertToCommand( ConverterTypes.ROMAN, numeric); //convert to a roman numeral
		try
		{

			String expectedValue = "MLXVI";
			c.execute();
			ConverterResult<String> result = c.getResult();
			assertEquals( expectedValue, result.getResult() );
		}
		catch( ConverterExecutionException ex )
		{
			fail( "Value is not a roman numeral." );			
		}
	}	
}

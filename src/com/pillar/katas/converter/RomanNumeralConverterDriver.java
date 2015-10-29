package com.pillar.katas.converter;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.pillar.katas.converter.commands.ConvertFromCommand;
import com.pillar.katas.converter.commands.ConvertToCommand;
import com.pillar.katas.converter.commands.ConverterCommand;
import com.pillar.katas.converter.commands.ConverterExecutionException;
import com.pillar.katas.converter.commands.ConverterResult;

public class RomanNumeralConverterDriver {
	
	private static final String COMMAND_ROMAN = "1";
	private static final String COMMAND_ARABIC = "2";
	private static final String COMMAND_HELP = "HELP";
	private static final String COMMAND_QUIT = "QUIT";
	
	public RomanNumeralConverterDriver()
	{
	}
	
	public void printHelp()
	{
		System.out.println( "Hello and welcome to the Roman Numeral Converter!" );
		System.out.println( "I'm glad you've decided to try me out.  Now...");
		System.out.println( "Little help here...");		
		System.out.println( "Enter [1] at the Conv> cmd prompt to convert from Arabic Numbers to Roman Numerals.");
		System.out.println( "Enter [2] at the Conv> cmd prompt to convert from Roman Numerals to Arabic Numbers.");
		System.out.println( "Enter [quit] at Conv> cmd prompt to exit the application.  Why do that though?" );
		System.out.println( "Enter [help] at Conv> cmd prompt to print this message again." );
	}
	
	
	public void run()
	{
		String command = "";
		BufferedReader r;
		do
		{
			System.out.print( "Conv[1]>" );
			try
			{
				r = new BufferedReader(new InputStreamReader( System.in ));
				command = r.readLine().toUpperCase();
				if( "".equals(command) || COMMAND_ROMAN.equals(command) )
				{
					System.out.println( "you chose arabic to roman numeral converter.");
					System.out.print( "Enter arabic value]" );
					String arabicValue = r.readLine();
					convertTo( arabicValue );
					
				}
				else if( COMMAND_ARABIC.equals(command))
				{
					System.out.println( "you chose roman numeral to arabic converter.");
					System.out.print( "Enter roman numeral]" );
					String romanValue = r.readLine();
					convertFrom( romanValue );
				}
				else if( COMMAND_HELP.equals(command))
				{
					printHelp();
				}				
				else if( COMMAND_QUIT.equals(command))
				{
					System.out.println( "Enjoyed chatting... Have a nice day!");
				}				
				else
				{
					System.out.println( "Choose 1 for roman, 2 for arabic");
				}
			}
			catch( ConverterExecutionException ex )
			{
				if( ex.getCause() != null && ex.getCause() instanceof NotARomanNumeralException )
				{
					System.out.println( "The value entered can't be converted..."  + "It's either invalid or exceeds the max roman numeral of 3999." );
				}
			}			
			catch( Exception ex )
			{
				System.err.println( "I couldn't read the data from the console." );
			}

		} while ( !COMMAND_QUIT.equals(command) );
		
	}
	
	
	public void convertTo( String numericValue ) throws ConverterExecutionException
	{
		try
		{
			int numeric = new Integer( numericValue );
			ConverterCommand<String> command = new ConvertToCommand( ConverterTypes.ROMAN, numeric );
			command.execute();
			ConverterResult<String> result = command.getResult();
			System.out.println( "The roman numeral is: " + result.getResult() );
		}
		catch( NumberFormatException ex )
		{
			System.out.println( numericValue + " is not a valid number!  Please enter another number." );
		}
	}

	public void convertFrom( String romanValue ) throws ConverterExecutionException
	{
		ConverterCommand<Integer> command = new ConvertFromCommand( ConverterTypes.ROMAN, romanValue );
		command.execute();
		ConverterResult<Integer> result = command.getResult();
		System.out.println( "The arabic number is: " + result.getResult() );		
	}	
	
	public static void main(String[] args)
	{
		RomanNumeralConverterDriver driver = new RomanNumeralConverterDriver();
		driver.printHelp();
		driver.run();
	}

}

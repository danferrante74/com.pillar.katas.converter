package com.pillar.katas.converter;


/**
 * This is the control layer...
 *
 */
public class RomanNumeralConverter implements IConverterControl {

	/**this here is the data model!!! It normally would be in another class.  view will never mess with this.**/
	private static final int[] numericValues    = {1000, 900 , 500, 400 , 100, 90  , 50 ,  40 , 10 ,   9 ,  5 ,   4 ,  1};
	private static final String[] numeralValues = {"M" , "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

	private static final int MAX_ROMAN_NUMERAL = 3999;
	
	public RomanNumeralConverter()
	{
	}
	
	
	
	/* (non-Javadoc)
	 * @see com.pillar.katas.converter.IConverterControl#convertTo(int)
	 */
	@Override
	public String convertTo( int x ) throws NotARomanNumeralException 
	{		
		if( x > MAX_ROMAN_NUMERAL || x <= 0 )
			throw new NotARomanNumeralException();
		
		StringBuilder numeral = new StringBuilder();		
		int runningTotal = x;
		
		for(int i=0; i<numericValues.length;)
		{
			int key = numericValues[i];
			if( runningTotal - key >= 0 )
			{
				numeral.append( numeralValues[i] );
				runningTotal = runningTotal - key;
				continue;
			}
			++i;				
		}			
		return numeral.toString();
	}

}

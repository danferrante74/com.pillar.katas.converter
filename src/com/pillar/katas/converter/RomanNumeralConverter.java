package com.pillar.katas.converter;


/**
 * This is the control layer...
 *
 */
public class RomanNumeralConverter implements IConverterControl {

	/**this here is the data model!!! It normally would be in another class.  view will never mess with this**/
	private static final int[] numericValues    = {1000, 900 , 500, 400 , 100, 90  , 50 ,  40 , 10 ,   9 ,  5 ,   4 ,  1};
	private static final String[] numeralValues = {"M" , "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
	private static final String[] invalidValues = {"IIII", "XXXX", "CCCC", "MMMM", "VV", "LL", "DD" };
	
	private static final int MAX_ROMAN_NUMERAL = 3999;
	
	public RomanNumeralConverter()
	{
	}
	
	
	
	/* (non-Javadoc)
	 * @see com.pillar.katas.converter.IConverterControl#convertTo(int)
	 */
	@Override
	public String convertTo( int x ) throws NotAValidNumeralException 
	{		
		if( x > MAX_ROMAN_NUMERAL || x <= 0 )
			throw new NotAValidNumeralException();
		
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



	@Override
	public int convertFrom(String rn) throws NotAValidNumeralException {
		if( rn == null || "".equals(rn))
			throw new NotAValidNumeralException();
		
		//check that chars I,X,C,M are repeated max 3 times
		//check that V, L, D are not repeated
		rn = rn.toUpperCase();
		for (int i = 0; i < invalidValues.length; i++) {
			String invalidValue = invalidValues[i];
			if( rn.indexOf( invalidValue ) >= 0 )
			{
				throw new NotAValidNumeralException();				
			}
		}
		
		int value = 0;
		int currentValue = 0;
		int lastValue = 0;
		for( int i = (rn.length() - 1); i >= 0; i--)
		{
			currentValue = getSegmentValue( String.valueOf( rn.charAt(i) ) );
			if( currentValue <= 0 ) 
				throw new NotAValidNumeralException();

			if(currentValue >= lastValue) 
				value+=currentValue;
			else 
				value -= currentValue; 			
			lastValue = currentValue;
		}
		return value;
	}
	
	private int getSegmentValue( String segment )
	{
		for (int i = 0; i < numeralValues.length; i++) {
			if( numeralValues[i].equals( segment ) )
			{
				return numericValues[i];
			}
		}
		return -1;
	}	

}

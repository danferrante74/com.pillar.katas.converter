package com.pillar.katas.converter.commands;

import com.pillar.katas.converter.ConverterControlFactory;
import com.pillar.katas.converter.ConverterTypes;
import com.pillar.katas.converter.IConverterControl;
import com.pillar.katas.converter.NotAValidNumeralException;

public class ConvertToCommand extends ConverterCommand<String> {

	private int numericValue;
		
	public ConvertToCommand(ConverterTypes type, int numericValue) {
		super(type);
		this.numericValue = numericValue;
	}

	@Override
	public void execute() throws ConverterExecutionException {
		IConverterControl controller = new ConverterControlFactory().getConverter(super.getType());
		try
		{
			String value = controller.convertTo(this.numericValue);
			super.setResult( new ConverterResult<String>(value) );
		}
		catch( NotAValidNumeralException ex )
		{
			throw new ConverterExecutionException( ex );
		}
	}

}

package com.pillar.katas.converter.commands;

import com.pillar.katas.converter.ConverterControlFactory;
import com.pillar.katas.converter.ConverterTypes;
import com.pillar.katas.converter.IConverterControl;
import com.pillar.katas.converter.NotAValidNumeralException;

public class ConvertFromCommand extends ConverterCommand<Integer> {

	private String fromValue;
	
	public ConvertFromCommand(ConverterTypes type, String fromValue) {
		super(type);
		this.fromValue = fromValue;
	}

	@Override
	public void execute() throws ConverterExecutionException {
		IConverterControl controller = new ConverterControlFactory().getConverter(super.getType());
		try
		{
			int value = controller.convertFrom(this.fromValue);
			super.setResult( new ConverterResult<Integer>(value) );
		}
		catch( NotAValidNumeralException ex )
		{
			throw new ConverterExecutionException( ex );
		}		
	}
}

package com.pillar.katas.converter.commands;

import com.pillar.katas.converter.ConverterTypes;

public abstract class ConverterCommand<T> {

	private ConverterTypes type;
	private ConverterResult<T> result;
	
	
	public ConverterCommand( ConverterTypes type )
	{
		this.type = type;
	}
	
	public ConverterTypes getType() {
		return type;
	}
	
	public abstract void execute() throws ConverterExecutionException;
	
	
	public ConverterResult<T> getResult()
	{
		return this.result;
	}
	
	
	protected void setResult( ConverterResult<T> result )
	{
		this.result = result;
	}
	
	
	
	
}

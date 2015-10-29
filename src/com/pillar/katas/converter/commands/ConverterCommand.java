package com.pillar.katas.converter.commands;

import com.pillar.katas.converter.ConverterTypes;

public abstract class ConverterCommand<T> {

	private ConverterTypes type;
	private ConverterResult<T> result;
	
	/**
	 * 
	 * @param type
	 */
	public ConverterCommand( ConverterTypes type )
	{
		this.type = type;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public ConverterTypes getType() {
		return type;
	}
	
	
	/**
	 * executes one of the converter commands
	 * @throws ConverterExecutionException
	 */
	public abstract void execute() throws ConverterExecutionException;
	
	
	
	/**
	 * 
	 * @return ConverterResult<T> is the conversion result which allows us to grab a type safe result.
	 */
	public ConverterResult<T> getResult()
	{
		return this.result;
	}
	
	
	/**
	 * 
	 * @param result
	 */
	protected void setResult( ConverterResult<T> result )
	{
		this.result = result;
	}
	
	
	
	
}

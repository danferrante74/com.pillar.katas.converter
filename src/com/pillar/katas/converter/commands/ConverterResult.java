package com.pillar.katas.converter.commands;

public class ConverterResult<T> {

	private T result;
	
	public ConverterResult(T result)
	{
		this.result = result;
	}
	
	public T getResult()
	{
		return this.result;
	}
	
}

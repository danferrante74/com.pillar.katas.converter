package com.pillar.katas.converter.commands;

@SuppressWarnings("serial")
public class ConverterExecutionException extends Exception {

	public ConverterExecutionException() {
	}

	public ConverterExecutionException(String message) {
		super(message);
	}

	public ConverterExecutionException(Throwable cause) {
		super(cause);
	}

	public ConverterExecutionException(String message, Throwable cause) {
		super(message, cause);
	}

}

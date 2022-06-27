package com.example.demo.service;

public class DataNotFoundException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DataNotFoundException(String message) {
        super(message);
    }

    public DataNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
}

}
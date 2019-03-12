package br.com.taxidobarba.exception;

public class BusinessExpetion extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BusinessExpetion(String message) {
		super(message);
	}

}

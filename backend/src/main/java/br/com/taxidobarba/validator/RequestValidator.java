package br.com.taxidobarba.validator;

public interface RequestValidator<T> {

	void validateOnSave(T request);
	
	void validateOnUpdate(T request, String id);
	
}

package br.com.taxidobarba.validator;

public interface RequestValidator<T> {

    void validateOnSave(T request);

    default void validateOnUpdate(T request, String id) {
    }

}

package dev.guedes.prayforoneanother.validators;

/**
 * Generic interface for validating objects of type T.
 * Implementations should perform validation logic and throw appropriate exceptions
 * when validation fails.
 *
 * @param <T> the type of object to be validated
 * @author João Guedes
 */
public interface Validator<T> {
    void validate(T value);
}

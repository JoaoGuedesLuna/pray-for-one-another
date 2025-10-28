package dev.guedes.prayforoneanother.validators;

import dev.guedes.prayforoneanother.exceptions.NullArgumentException;

/**
 * Validator that checks if an argument is not null.
 * Validates objects of any type for null values.
 * Implements the Singleton pattern to ensure only one instance exists.
 *
 * @author João Guedes
 */
public class NotNullValidator implements Validator<Object> {
    @Override
    public void validate(Object value) {
        if (value == null) throw new NullArgumentException();
    }
}

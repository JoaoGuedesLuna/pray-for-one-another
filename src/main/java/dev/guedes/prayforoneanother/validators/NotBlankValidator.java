package dev.guedes.prayforoneanother.validators;

import dev.guedes.prayforoneanother.exceptions.BlankArgumentException;

/**
 * Validator that checks if a string argument is not blank (null-safe).
 * Only validates String objects; other types pass validation silently.
 * Implements the Singleton pattern to ensure only one instance exists.
 *
 * @author João Guedes
 */
public class NotBlankValidator implements Validator<Object> {
    @Override
    public void validate(Object value) {
        if (value instanceof String s && s.isBlank()) {
            throw new BlankArgumentException();
        }
    }
}

package dev.guedes.prayforoneanother.validators;

import dev.guedes.prayforoneanother.exceptions.NullArgumentException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Test class for {@link NotNullValidator}.
 * Verifies that the validator correctly identifies and handles null values.
 *
 * @author João Guedes
 */
class NotNullValidatorTest {
    private final NotNullValidator validator = NotNullValidator.getInstance();

    @Test
    void validate_ShouldThrowException_WhenArgumentIsNull() {
        assertThrows(NullArgumentException.class, () -> validator.validate(null));
    }

    @Test
    void validate_ShouldNotThrowException_WhenArgumentIsNotNull() {
        assertDoesNotThrow(() -> validator.validate("non-null value"));
    }

    @Test
    void validate_ShouldWorkWithDifferentObjectTypes() {
        assertDoesNotThrow(() -> validator.validate(123));
        assertDoesNotThrow(() -> validator.validate(new Object()));
    }

    @Test
    void getInstance_ShouldReturnSameInstance() {
        NotNullValidator instance1 = NotNullValidator.getInstance();
        NotNullValidator instance2 = NotNullValidator.getInstance();

        assertSame(instance1, instance2);
    }
}

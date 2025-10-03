package dev.guedes.prayforoneanother.validators;

import com.google.inject.Inject;
import dev.guedes.prayforoneanother.exceptions.NullArgumentException;
import extensions.GuiceJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Test class for {@link NotNullValidator}.
 * Verifies that the validator correctly identifies and handles null values.
 *
 * @author João Guedes
 */
@ExtendWith(GuiceJUnit5Extension.class)
class NotNullValidatorTest {
    private final NotNullValidator validator;

    @Inject
    NotNullValidatorTest(NotNullValidator validator) { this.validator = validator; }

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
}

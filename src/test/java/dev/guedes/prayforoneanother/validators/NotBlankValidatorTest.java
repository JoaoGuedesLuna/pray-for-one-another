package dev.guedes.prayforoneanother.validators;

import dev.guedes.prayforoneanother.exceptions.BlankArgumentException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Test class for {@link NotBlankValidator}.
 * Verifies that the validator correctly identifies and handles blank strings.
 *
 * @author João Guedes
 */
class NotBlankValidatorTest {
    private final NotBlankValidator validator = NotBlankValidator.getInstance();

    @Test
    void validate_ShouldThrowException_WhenStringIsBlank() {
        assertThrows(BlankArgumentException.class, () -> validator.validate(""));
        assertThrows(BlankArgumentException.class, () -> validator.validate("   "));
        assertThrows(BlankArgumentException.class, () -> validator.validate("\n\t"));
    }

    @Test
    void validate_ShouldNotThrowException_WhenStringIsNotBlank() {
        assertDoesNotThrow(() -> validator.validate("hello"));
        assertDoesNotThrow(() -> validator.validate("  text  "));
    }

    @Test
    void validate_ShouldNotThrowException_WhenArgumentIsNotString() {
        assertDoesNotThrow(() -> validator.validate(123));
        assertDoesNotThrow(() -> validator.validate(new Object()));
        assertDoesNotThrow(() -> validator.validate(null));
    }

    @Test
    void getInstance_ShouldReturnSameInstance() {
        NotBlankValidator instance1 = NotBlankValidator.getInstance();
        NotBlankValidator instance2 = NotBlankValidator.getInstance();

        assertSame(instance1, instance2);
    }
}

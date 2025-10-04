package dev.guedes.prayforoneanother.validators;

import com.google.inject.Inject;
import dev.guedes.prayforoneanother.exceptions.BlankArgumentException;
import extensions.GuiceJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Test class for {@link NotBlankValidator}.
 * Verifies that the validator correctly identifies and handles blank strings.
 *
 * @author João Guedes
 */
@ExtendWith(GuiceJUnit5Extension.class)
class NotBlankValidatorTest {
    private final NotBlankValidator validator;

    @Inject
    NotBlankValidatorTest(NotBlankValidator validator) { this.validator = validator; }

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
}

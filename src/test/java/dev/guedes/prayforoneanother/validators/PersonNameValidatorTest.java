package dev.guedes.prayforoneanother.validators;

import com.google.inject.Inject;
import dev.guedes.prayforoneanother.exceptions.InvalidNameException;
import extensions.GuiceJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Test class for {@link PersonNameValidator}.
 * Verifies that the composite validator correctly validates person names
 * by combining null and blank validation rules.
 *
 * @author João Guedes
 */
@ExtendWith(GuiceJUnit5Extension.class)
class PersonNameValidatorTest {
    private final PersonNameValidator validator;

    @Inject
    PersonNameValidatorTest(PersonNameValidator validator) { this.validator = validator; }

    @Test
    void validate_ShouldThrowInvalidNameException_WhenNameIsNull() {
        assertThrows(InvalidNameException.class, () -> validator.validate(null));
    }

    @Test
    void validate_ShouldThrowInvalidNameException_WhenNameIsBlank() {
        assertThrows(InvalidNameException.class, () -> validator.validate(""));
        assertThrows(InvalidNameException.class, () -> validator.validate("   "));
        assertThrows(InvalidNameException.class, () -> validator.validate("\t\n"));
    }

    @Test
    void validate_ShouldNotThrowException_WhenNameIsValid() {
        assertDoesNotThrow(() -> validator.validate("John"));
        assertDoesNotThrow(() -> validator.validate(" Maria "));
    }
}

package dev.guedes.prayforoneanother.validators;

import dev.guedes.prayforoneanother.exceptions.InvalidNameException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Test class for {@link PersonNameValidator}.
 * Verifies that the composite validator correctly validates person names
 * by combining null and blank validation rules.
 *
 * @author João Guedes
 */
class PersonNameValidatorTest {
    private final PersonNameValidator validator = PersonNameValidator.getInstance();

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

    @Test
    void getInstance_ShouldReturnSameInstance() {
        PersonNameValidator instance1 = PersonNameValidator.getInstance();
        PersonNameValidator instance2 = PersonNameValidator.getInstance();

        assertSame(instance1, instance2);
    }
}

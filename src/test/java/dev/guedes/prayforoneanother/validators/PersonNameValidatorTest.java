package dev.guedes.prayforoneanother.validators;

import com.google.inject.Inject;
import extensions.GuiceJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import dev.guedes.prayforoneanother.exceptions.InvalidNameException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

/*
 * Copyright (c) 2026 João Guedes
 * Project : Pray for One Another
 * File : PersonNameValidatorTest.java
 * Created on : 2026-11-05 17:00
 * Last modified: 2026-11-05 17:00
 *
 * Author : João Guedes
 * GitHub : https://github.com/JoaoGuedesLuna
 *
 * Copyright (c) 2026 João Guedes. All Rights Reserved.
 * Licensed under the MIT License.
 *
 * https://opensource.org/licenses/MIT
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

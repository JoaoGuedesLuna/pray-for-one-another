package dev.guedes.prayforoneanother.validators;

import com.google.inject.Inject;
import extensions.GuiceJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import dev.guedes.prayforoneanother.exceptions.BlankArgumentException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

/*
 * Copyright (c) 2026 João Guedes
 * Project : Pray for One Another
 * File : NotBlankValidatorTest.java
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
        assertDoesNotThrow(() -> validator.validate("text"));
        assertDoesNotThrow(() -> validator.validate("  text  "));
    }

    @Test
    void validate_ShouldNotThrowException_WhenArgumentIsNotString() {
        assertDoesNotThrow(() -> validator.validate(null));
        assertDoesNotThrow(() -> validator.validate(123));
        assertDoesNotThrow(() -> validator.validate(new Object()));
    }
}

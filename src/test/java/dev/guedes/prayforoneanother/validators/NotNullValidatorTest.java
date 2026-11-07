package dev.guedes.prayforoneanother.validators;

import com.google.inject.Inject;
import extensions.GuiceJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import dev.guedes.prayforoneanother.exceptions.NullArgumentException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

/*
 * Copyright (c) 2026 João Guedes
 * Project : Pray for One Another
 * File : NotNullValidatorTest.java
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

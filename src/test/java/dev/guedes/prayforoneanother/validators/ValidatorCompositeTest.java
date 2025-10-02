package dev.guedes.prayforoneanother.validators;

import com.google.inject.Inject;
import extensions.GuiceJUnit5Extension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.doThrow;

/**
 * Test class for {@link ValidatorComposite}.
 * Ensures that the composite correctly delegates validation to all contained validators and handles exceptions.
 *
 * @author João
 */
@ExtendWith(GuiceJUnit5Extension.class)
class ValidatorCompositeTest {
    private final ValidatorComposite composite;
    private Validator<Object> validator1;
    private Validator<Object> validator2;

    @Inject
    ValidatorCompositeTest(ValidatorComposite composite) { this.composite = composite; }

    @BeforeEach
    void setUp() {
        validator1 = mock(Validator.class);
        validator2 = mock(Validator.class);

        composite.add(validator1);
        composite.add(validator2);
    }

    @Test
    void validate_ShouldCallAllValidators() {
        Object value = "test";
        composite.validate(value);

        verify(validator1, times(1)).validate(value);
        verify(validator2, times(1)).validate(value);
    }

    @Test
    void validate_ShouldPropagateException_WhenAnyValidatorFails() {
        Object value = "invalid";

        doThrow(new RuntimeException("validation failed.")).when(validator1).validate(value);

        assertThrows(RuntimeException.class, () -> composite.validate(value));

        verify(validator2, times(0)).validate(value);
    }

    @Test
    void validate_ShouldNotThrowException_WhenAllValidatorsPass() {
        Object value = "valid";

        assertDoesNotThrow(() -> composite.validate(value));
    }
}

package dev.guedes.prayforoneanother.validators;

import com.google.inject.Inject;
import dev.guedes.prayforoneanother.exceptions.InvalidNameException;

/**
 * Composite validator specifically for validating person names.
 * Combines null validation and blank validation into a single validator.
 * Wraps validation exceptions in a domain-specific InvalidNameException.
 * Implements the Singleton pattern to ensure only one instance exists.
 *
 * @author João Guedes
 */
public class PersonNameValidator implements Validator<String> {
    private final ValidatorComposite validatorComposite;

    @Inject
    private PersonNameValidator(
            ValidatorComposite validatorComposite,
            NotNullValidator notNullValidator,
            NotBlankValidator notBlankValidator
    ) {
        this.validatorComposite = validatorComposite;
        this.validatorComposite.add(notNullValidator);
        this.validatorComposite.add(notBlankValidator);
    }

    @Override
    public void validate(String value) {
        try {
            validatorComposite.validate(value);
        } catch (Exception e) {
            throw new InvalidNameException();
        }
    }
}

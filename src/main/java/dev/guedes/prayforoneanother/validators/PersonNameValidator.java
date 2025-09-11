package dev.guedes.prayforoneanother.validators;

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

    private PersonNameValidator() {
        this.validatorComposite = new ValidatorComposite();
        this.validatorComposite.add(NotNullValidator.getInstance());
        this.validatorComposite.add(NotBlankValidator.getInstance());
    }

    @Override
    public void validate(String value) {
        try {
            validatorComposite.validate(value);
        } catch (Exception e) {
            throw new InvalidNameException();
        }
    }

    public static PersonNameValidator getInstance() { return InstanceHolder.INSTANCE; }

    private static class InstanceHolder {
        private static final PersonNameValidator INSTANCE = new PersonNameValidator();
    }
}

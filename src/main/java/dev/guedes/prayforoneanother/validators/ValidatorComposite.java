package dev.guedes.prayforoneanother.validators;

import java.util.LinkedList;
import java.util.List;

/**
 * A composite validator that combines multiple validators and executes them sequentially.
 * This allows for chaining validation rules and applying them to the same object.
 *
 * @author João Guedes
 */
public class ValidatorComposite implements Validator<Object> {
    private final List<Validator<Object>> validators;

    public ValidatorComposite() { this.validators = new LinkedList<>(); }

    @Override
    public void validate(Object value) {
        validators.forEach(validator -> validator.validate(value));
    }

    public void add(Validator<Object> validator) { validators.add(validator); }
}

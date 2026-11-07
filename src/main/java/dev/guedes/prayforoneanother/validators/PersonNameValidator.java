package dev.guedes.prayforoneanother.validators;

import com.google.inject.Inject;

import dev.guedes.prayforoneanother.exceptions.InvalidNameException;

/*
 * Copyright (c) 2026 João Guedes
 * Project : Pray for One Another
 * File : PersonNameValidator.java
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

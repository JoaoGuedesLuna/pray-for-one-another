package dev.guedes.prayforoneanother.validators;

import java.util.LinkedList;
import java.util.List;

/*
 * Copyright (c) 2026 João Guedes
 * Project : Pray for One Another
 * File : ValidatorComposite.java
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
public class ValidatorComposite implements Validator<Object> {
    private final List<Validator<Object>> validators;

    public ValidatorComposite() { this.validators = new LinkedList<>(); }

    @Override
    public void validate(Object value) {
        validators.forEach(validator -> validator.validate(value));
    }

    public void add(Validator<Object> validator) { validators.add(validator); }
}

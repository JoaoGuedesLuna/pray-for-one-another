package dev.guedes.prayforoneanother.mappers.impl;

import com.google.inject.Inject;
import java.util.List;

import dev.guedes.prayforoneanother.mappers.PersonMapper;
import dev.guedes.prayforoneanother.models.Person;
import dev.guedes.prayforoneanother.validators.NotNullValidator;
import dev.guedes.prayforoneanother.validators.PersonNameValidator;

/*
 * Copyright (c) 2026 João Guedes
 * Project : Pray for One Another
 * File : PersonMapperImpl.java
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
public class PersonMapperImpl implements PersonMapper {
    private final PersonNameValidator personNameValidator;
    private final NotNullValidator notNullValidator;

    @Inject
    public PersonMapperImpl(
            PersonNameValidator personNameValidator,
            NotNullValidator notNullValidator
    ) {
        this.personNameValidator = personNameValidator;
        this.notNullValidator = notNullValidator;
    }

    public List<Person> toPeople(List<String> names) {
        notNullValidator.validate(names);
        return names.stream()
                .map(this::toPerson)
                .toList();
    }

    public Person toPerson(String name) {
        personNameValidator.validate(name);
        return new Person(name);
    }
}

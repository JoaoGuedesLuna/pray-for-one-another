package dev.guedes.prayforoneanother.mappers.impl;

import com.google.inject.Inject;
import dev.guedes.prayforoneanother.mappers.PersonMapper;
import dev.guedes.prayforoneanother.models.Person;
import dev.guedes.prayforoneanother.validators.NotNullValidator;
import dev.guedes.prayforoneanother.validators.PersonNameValidator;
import java.util.List;

/**
 * Concrete implementation of {@link PersonMapper}.
 *
 * @author João Guedes
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

    public Person toPerson(String name) {
        personNameValidator.validate(name);
        return new Person(name);
    }

    public List<Person> toPeople(List<String> names) {
        notNullValidator.validate(names);
        return names.stream()
                .map(this::toPerson)
                .toList();
    }
}

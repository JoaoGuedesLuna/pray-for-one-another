package dev.guedes.prayforoneanother.mappers.impl;

import dev.guedes.prayforoneanother.mappers.PersonMapper;
import dev.guedes.prayforoneanother.models.Person;
import dev.guedes.prayforoneanother.validators.NotNullValidator;
import dev.guedes.prayforoneanother.validators.PersonNameValidator;
import dev.guedes.prayforoneanother.validators.Validator;
import java.util.List;

/**
 * Implementation of {@link PersonMapper} that convert objects to Person entities.
 *
 * @author João Guedes
 */
public class PersonMapperImpl implements PersonMapper {
    private PersonMapperImpl() {}

    @Override
    public Person toPerson(String name) {
        Validator<String> validator = PersonNameValidator.getInstance();
        validator.validate(name);

        return new Person(name);
    }

    @Override
    public List<Person> toPeople(List<String> names) {
        Validator<Object> validator = NotNullValidator.getInstance();
        validator.validate(names);

        return names.stream()
                .map(this::toPerson)
                .toList();
    }

    public static PersonMapper getInstance() { return InstanceHolder.INSTANCE; }

    private static class InstanceHolder {
        private static final PersonMapper INSTANCE = new PersonMapperImpl();
    }
}

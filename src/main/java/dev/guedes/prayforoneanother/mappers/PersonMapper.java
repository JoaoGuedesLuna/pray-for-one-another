package dev.guedes.prayforoneanother.mappers;

import dev.guedes.prayforoneanother.models.Person;
import dev.guedes.prayforoneanother.validators.NotNullValidator;
import dev.guedes.prayforoneanother.validators.PersonNameValidator;
import dev.guedes.prayforoneanother.validators.Validator;
import java.util.List;

/**
 * Mapper that convert objects to Person entities.
 *
 * @author João Guedes
 */
public class PersonMapper {
    private PersonMapper() {}

    public static Person toPerson(String name) {
        Validator<String> validator = PersonNameValidator.getInstance();
        validator.validate(name);

        return new Person(name);
    }

    public static List<Person> toPeople(List<String> names) {
        Validator<Object> validator = NotNullValidator.getInstance();
        validator.validate(names);

        return names.stream()
                .map(PersonMapper::toPerson)
                .toList();
    }
}

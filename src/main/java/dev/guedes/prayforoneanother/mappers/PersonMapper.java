package dev.guedes.prayforoneanother.mappers;

import dev.guedes.prayforoneanother.models.Person;
import java.util.List;

/**
 * Mapper interface for converting data into {@link Person} object.
 *
 * @author João Guedes
 */
public interface PersonMapper {
    Person toPerson(String name);
    List<Person> toPeople(List<String> names);
}

package dev.guedes.prayforoneanother.mappers;

import dev.guedes.prayforoneanother.models.Person;
import java.util.List;

/**
 * Interface for mapping objects to Person entities.
 *
 * @author João Guedes
 */
public interface PersonMapper {
    Person toPerson(String name);
    List<Person> toPeople(List<String> names);
}

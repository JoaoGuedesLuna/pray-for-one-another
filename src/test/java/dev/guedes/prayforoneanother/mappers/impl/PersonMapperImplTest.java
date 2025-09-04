package dev.guedes.prayforoneanother.mappers.impl;

import dev.guedes.prayforoneanother.exceptions.InvalidNameException;
import dev.guedes.prayforoneanother.exceptions.NullArgumentException;
import dev.guedes.prayforoneanother.mappers.PersonMapper;
import dev.guedes.prayforoneanother.models.Person;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Test class for {@link PersonMapperImpl}.
 * Verifies that the mapper correctly converts names to Person objects with proper validation.
 *
 * @author João Guedes
 */
class PersonMapperImplTest {
    private final PersonMapper mapper = PersonMapperImpl.getInstance();

    @Test
    void toPeople_ShouldThrowNullArgumentException_WhenNamesIsNull() {
        assertThrows(NullArgumentException.class, () -> mapper.toPeople(null));
    }

    @Test
    void toPerson_ShouldThrowInvalidNameException_WhenNameIsInvalid() {
        assertThrows(InvalidNameException.class, () -> mapper.toPerson(null));
        assertThrows(InvalidNameException.class, () -> mapper.toPerson(""));
        assertThrows(InvalidNameException.class, () -> mapper.toPerson("   "));
    }

    @Test
    void toPerson_ShouldReturnPerson_WhenNameIsValid() {
        Person person = mapper.toPerson("Alice");
        assertNotNull(person);
        assertEquals("Alice", person.getName());
    }

    @Test
    void toPeople_ShouldThrowInvalidNameException_WhenAnyNameIsNull() {
        List<String> names = new ArrayList<>(3);
        names.add("Alice");
        names.add(null);
        names.add("Charlie");

        assertThrows(InvalidNameException.class, () -> mapper.toPeople(names));
    }

    @Test
    void toPeople_ShouldThrowInvalidNameException_WhenAnyNameIsBlank() {
        List<String> names = new ArrayList<>(3);
        names.add("Alice");
        names.add("");
        names.add("Charlie");

        assertThrows(InvalidNameException.class, () -> mapper.toPeople(names));
    }

    @Test
    void toPeople_ShouldReturnListOfPersons_WhenNamesAreValid() {
        List<String> names = new ArrayList<>(3);
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");

        List<Person> people = mapper.toPeople(names);

        assertEquals(3, people.size());
        assertEquals("Alice", people.get(0).getName());
        assertEquals("Bob", people.get(1).getName());
        assertEquals("Charlie", people.get(2).getName());
    }

    @Test
    void getInstance_ShouldReturnSameInstance() {
        PersonMapper instance1 = PersonMapperImpl.getInstance();
        PersonMapper instance2 = PersonMapperImpl.getInstance();

        assertSame(instance1, instance2);
    }
}

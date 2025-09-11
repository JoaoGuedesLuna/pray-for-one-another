package dev.guedes.prayforoneanother.mappers;

import dev.guedes.prayforoneanother.exceptions.InvalidNameException;
import dev.guedes.prayforoneanother.exceptions.NullArgumentException;
import dev.guedes.prayforoneanother.models.Person;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Test class for {@link PersonMapper}.
 * Verifies that the mapper correctly converts names to Person objects with proper validation.
 *
 * @author João Guedes
 */
class PersonMapperTest {
    @Test
    void toPeople_ShouldThrowNullArgumentException_WhenNamesIsNull() {
        assertThrows(NullArgumentException.class, () -> PersonMapper.toPeople(null));
    }

    @Test
    void toPerson_ShouldThrowInvalidNameException_WhenNameIsInvalid() {
        assertThrows(InvalidNameException.class, () -> PersonMapper.toPerson(null));
        assertThrows(InvalidNameException.class, () -> PersonMapper.toPerson(""));
        assertThrows(InvalidNameException.class, () -> PersonMapper.toPerson("   "));
    }

    @Test
    void toPerson_ShouldReturnPerson_WhenNameIsValid() {
        Person person = PersonMapper.toPerson("Alice");
        assertNotNull(person);
        assertEquals("Alice", person.getName());
    }

    @Test
    void toPeople_ShouldThrowInvalidNameException_WhenAnyNameIsNull() {
        List<String> names = new ArrayList<>(3);
        names.add("Alice");
        names.add(null);
        names.add("Charlie");

        assertThrows(InvalidNameException.class, () -> PersonMapper.toPeople(names));
    }

    @Test
    void toPeople_ShouldThrowInvalidNameException_WhenAnyNameIsBlank() {
        List<String> names = new ArrayList<>(3);
        names.add("Alice");
        names.add("");
        names.add("Charlie");

        assertThrows(InvalidNameException.class, () -> PersonMapper.toPeople(names));
    }

    @Test
    void toPeople_ShouldReturnListOfPersons_WhenNamesAreValid() {
        List<String> names = new ArrayList<>(3);
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");

        List<Person> people = PersonMapper.toPeople(names);

        assertEquals(3, people.size());
        assertEquals("Alice", people.get(0).getName());
        assertEquals("Bob", people.get(1).getName());
        assertEquals("Charlie", people.get(2).getName());
    }
}

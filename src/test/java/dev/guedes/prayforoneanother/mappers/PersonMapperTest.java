package dev.guedes.prayforoneanother.mappers;

import com.google.inject.Inject;
import extensions.GuiceJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import java.util.ArrayList;
import java.util.List;

import dev.guedes.prayforoneanother.exceptions.InvalidNameException;
import dev.guedes.prayforoneanother.exceptions.NullArgumentException;
import dev.guedes.prayforoneanother.models.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

/*
 * Copyright (c) 2026 João Guedes
 * Project : Pray for One Another
 * File : PersonMapperTest.java
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
@ExtendWith(GuiceJUnit5Extension.class)
class PersonMapperTest {
    private final PersonMapper personMapper;

    @Inject
    PersonMapperTest(PersonMapper personMapper) { this.personMapper = personMapper; }

    @Test
    void toPeople_ShouldThrowNullArgumentException_WhenNamesIsNull() {
        assertThrows(NullArgumentException.class, () -> personMapper.toPeople(null));
    }

    @Test
    void toPeople_ShouldThrowInvalidNameException_WhenAnyNameIsNull() {
        List<String> names = new ArrayList<>(3);

        names.add("Alexsandra");
        names.add(null);
        names.add("João");

        assertThrows(InvalidNameException.class, () -> personMapper.toPeople(names));
    }

    @Test
    void toPeople_ShouldThrowInvalidNameException_WhenAnyNameIsBlank() {
        List<String> names = new ArrayList<>(3);

        names.add("Alexsandra");
        names.add("");
        names.add("João");

        assertThrows(InvalidNameException.class, () -> personMapper.toPeople(names));
    }

    @Test
    void toPeople_ShouldReturnListOfPersons_WhenNamesAreValid() {
        List<String> names = new ArrayList<>(3);

        names.add("Alexsandra");
        names.add("João");
        names.add("Mihay");

        List<Person> people = personMapper.toPeople(names);

        assertEquals(3, people.size());

        assertEquals("Alexsandra", people.get(0).name());
        assertEquals("João", people.get(1).name());
        assertEquals("Mihay", people.get(2).name());
    }

    @Test
    void toPerson_ShouldThrowInvalidNameException_WhenNameIsInvalid() {
        assertThrows(InvalidNameException.class, () -> personMapper.toPerson(null));
        assertThrows(InvalidNameException.class, () -> personMapper.toPerson(""));
        assertThrows(InvalidNameException.class, () -> personMapper.toPerson("   "));
    }

    @Test
    void toPerson_ShouldReturnPerson_WhenNameIsValid() {
        Person person = personMapper.toPerson("Alexsandra");

        assertNotNull(person);

        assertEquals("Alexsandra", person.name());
    }
}

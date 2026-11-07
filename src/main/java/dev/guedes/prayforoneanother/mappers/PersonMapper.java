package dev.guedes.prayforoneanother.mappers;

import java.util.List;

import dev.guedes.prayforoneanother.models.Person;

/*
 * Copyright (c) 2026 João Guedes
 * Project : Pray for One Another
 * File : PersonMapper.java
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
public interface PersonMapper {
    List<Person> toPeople(List<String> names);
    Person toPerson(String name);
}

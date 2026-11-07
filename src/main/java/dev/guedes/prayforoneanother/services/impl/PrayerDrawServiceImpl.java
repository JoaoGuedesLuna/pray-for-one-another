package dev.guedes.prayforoneanother.services.impl;

import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dev.guedes.prayforoneanother.mappers.PersonMapper;
import dev.guedes.prayforoneanother.models.Person;
import dev.guedes.prayforoneanother.models.PrayerPair;
import dev.guedes.prayforoneanother.services.PrayerDrawService;

/*
 * Copyright (c) 2026 João Guedes
 * Project : Pray for One Another
 * File : PrayerDrawServiceImpl.java
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
public class PrayerDrawServiceImpl implements PrayerDrawService {
    private final PersonMapper personMapper;

    @Inject
    public PrayerDrawServiceImpl(PersonMapper personMapper) { this.personMapper = personMapper; }

    @Override
    public List<PrayerPair> drawPrayerAssignments(List<String> names) {
        List<Person> people = personMapper.toPeople(names);

        int  size = people.size();

        if (size == 0) return List.of();

        if (size == 1) return List.of(new PrayerPair(people.get(0), people.get(0)));

        List<Person> receivers = new ArrayList<>(people);

        Collections.shuffle(receivers);

        for (int i = 0; i < size - 1; i++) {
            if (people.get(i).equals(receivers.get(i))) {
                Collections.swap(receivers, i, size - 1);
            }
        }

        if (people.get(size - 1).equals(receivers.get(size - 1))) {
            Collections.swap(receivers, size - 1, size - 2);
        }

        List<PrayerPair> prayerPairs = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            prayerPairs.add(new PrayerPair(people.get(i), receivers.get(i)));
        }

        return prayerPairs;
    }
}

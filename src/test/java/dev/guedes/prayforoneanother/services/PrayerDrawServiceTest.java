package dev.guedes.prayforoneanother.services;

import com.google.inject.Inject;
import extensions.GuiceJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import java.util.ArrayList;
import java.util.List;

import dev.guedes.prayforoneanother.models.PrayerPair;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
 * Copyright (c) 2026 João Guedes
 * Project : Pray for One Another
 * File : PrayerDrawServiceTest.java
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
class PrayerDrawServiceTest {
    private final PrayerDrawService prayerDrawService;

    @Inject
    PrayerDrawServiceTest(PrayerDrawService prayerDrawService) { this.prayerDrawService = prayerDrawService; }

    @Test
    void drawPrayerAssignments_ShouldReturnEmptyList_WhenNamesArrayIsEmpty() {
        List<String> emptyNames = new ArrayList<>();

        List<PrayerPair> result = prayerDrawService.drawPrayerAssignments(emptyNames);

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void drawPrayerAssignments_ShouldReturnSelfAssignment_WhenSinglePerson() {
        List<String> singleName = new ArrayList<>(1);

        singleName.add("João");

        List<PrayerPair> result = prayerDrawService.drawPrayerAssignments(singleName);

        assertNotNull(result);
        assertEquals(1, result.size());

        PrayerPair pair = result.get(0);

        assertEquals("João", pair.prayerPerson().name());
        assertEquals("João", pair.recipientPerson().name());
    }

    @Test
    void drawPrayerAssignments_ShouldReturnValidPairs_WhenTwoPeople() {
        List<String> names = new ArrayList<>(2);

        names.add("João");
        names.add("Alexsandra");

        List<PrayerPair> prayerPairs = prayerDrawService.drawPrayerAssignments(names);

        assertNotNull(prayerPairs);
        assertEquals(2, prayerPairs.size());

        assertValidPairs(names, prayerPairs);
    }

    @Test
    void drawPrayerAssignments_ShouldReturnValidPairs_WhenThreePeople() {
        List<String> names = new ArrayList<>(3);

        names.add("João");
        names.add("Alexsandra");
        names.add("Mihay");

        List<PrayerPair> prayerPairs = prayerDrawService.drawPrayerAssignments(names);

        assertNotNull(prayerPairs);
        assertEquals(3, prayerPairs.size());

        assertValidPairs(names, prayerPairs);
    }

    @Test
    void drawPrayerAssignments_ShouldAssignAllPeople_WhenMultiplePeople() {
        List<String> names = new ArrayList<>(5);

        names.add("João");
        names.add("Alexsandra");
        names.add("Mihay");
        names.add("Joyce");
        names.add("Marcone");

        List<PrayerPair> prayerPairs = prayerDrawService.drawPrayerAssignments(names);

        assertNotNull(prayerPairs);
        assertEquals(5, prayerPairs.size());

        assertValidPairs(names, prayerPairs);
    }

    @Test
    void drawPrayerAssignments_ShouldHandleDuplicateNames() {
        List<String> names = new ArrayList<>(3);

        names.add("João");
        names.add("João");
        names.add("Alexsandra");

        List<PrayerPair> result = prayerDrawService.drawPrayerAssignments(names);

        assertNotNull(result);
        assertEquals(3, result.size());
    }

    private void assertValidPairs(List<String> names, List<PrayerPair> prayerPairs) {
        for (String name : names) {
            long personAsPrayer = prayerPairs.stream()
                    .filter(pair -> pair.prayerPerson().name().equals(name))
                    .count();
            long personAsReceiver = prayerPairs.stream()
                    .filter(pair -> pair.recipientPerson().name().equals(name))
                    .count();

            assertEquals(1, personAsPrayer);
            assertEquals(1, personAsReceiver);
        }

        for (PrayerPair pair : prayerPairs) {
            assertNotEquals(pair.prayerPerson(), pair.recipientPerson());
        }
    }
}

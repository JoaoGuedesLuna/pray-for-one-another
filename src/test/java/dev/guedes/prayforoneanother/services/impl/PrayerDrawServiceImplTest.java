package dev.guedes.prayforoneanother.services.impl;

import dev.guedes.prayforoneanother.models.PrayerPair;
import dev.guedes.prayforoneanother.services.PrayerDrawService;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test class for {@link PrayerDrawServiceImpl}.
 * Verifies that the service correctly assigns prayer pairs with proper validation.
 *
 * @author João Guedes
 */
class PrayerDrawServiceImplTest {
    private final PrayerDrawService prayerDrawService = PrayerDrawServiceImpl.getInstance();

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
        singleName.add("John");

        List<PrayerPair> result = prayerDrawService.drawPrayerAssignments(singleName);

        assertNotNull(result);
        assertEquals(1, result.size());

        PrayerPair pair = result.get(0);
        assertEquals("John", pair.getPrayerPerson().getName());
        assertEquals("John", pair.getRecipientPerson().getName());
    }

    @Test
    void drawPrayerAssignments_ShouldReturnValidPairs_WhenTwoPeople() {
        List<String> names = new ArrayList<>(2);
        names.add("John");
        names.add("Mary");

        List<PrayerPair> prayerPairs = prayerDrawService.drawPrayerAssignments(names);

        assertNotNull(prayerPairs);
        assertEquals(2, prayerPairs.size());

        for (String name : names) {
            long personAsPrayer = prayerPairs.stream()
                    .filter(pair -> pair.getPrayerPerson().getName().equals(name))
                    .count();
            long personAsReceiver = prayerPairs.stream()
                    .filter(pair -> pair.getRecipientPerson().getName().equals(name))
                    .count();

            assertEquals(1, personAsPrayer);
            assertEquals(1, personAsReceiver);
        }

        for (PrayerPair pair : prayerPairs) {
            assertNotEquals(pair.getPrayerPerson(), pair.getRecipientPerson());
        }
    }

    @Test
    void drawPrayerAssignments_ShouldReturnValidPairs_WhenThreePeople() {
        List<String> names = new ArrayList<>(3);
        names.add("John");
        names.add("Mary");
        names.add("Peter");

        List<PrayerPair> prayerPairs = prayerDrawService.drawPrayerAssignments(names);

        assertNotNull(prayerPairs);
        assertEquals(3, prayerPairs.size());

        for (String name : names) {
            long personAsPrayer = prayerPairs.stream()
                    .filter(pair -> pair.getPrayerPerson().getName().equals(name))
                    .count();
            long personAsReceiver = prayerPairs.stream()
                    .filter(pair -> pair.getRecipientPerson().getName().equals(name))
                    .count();

            assertEquals(1, personAsPrayer);
            assertEquals(1, personAsReceiver);
        }

        for (PrayerPair pair : prayerPairs) {
            assertNotEquals(pair.getPrayerPerson(), pair.getRecipientPerson());
        }
    }

    @Test
    void drawPrayerAssignments_ShouldAssignAllPeople_WhenMultiplePeople() {
        List<String> names = new ArrayList<>(5);
        names.add("John");
        names.add("Mary");
        names.add("Peter");
        names.add("Anna");
        names.add("David");

        List<PrayerPair> prayerPairs = prayerDrawService.drawPrayerAssignments(names);

        assertNotNull(prayerPairs);
        assertEquals(5, prayerPairs.size());

        for (String name : names) {
            long personAsPrayer = prayerPairs.stream()
                    .filter(pair -> pair.getPrayerPerson().getName().equals(name))
                    .count();
            long personAsReceiver = prayerPairs.stream()
                    .filter(pair -> pair.getRecipientPerson().getName().equals(name))
                    .count();

            assertEquals(1, personAsPrayer);
            assertEquals(1, personAsReceiver);
        }

        for (PrayerPair pair : prayerPairs) {
            assertNotEquals(pair.getPrayerPerson(), pair.getRecipientPerson());
        }
    }

    @Test
    void drawPrayerAssignments_ShouldHandleDuplicateNames() {
        List<String> names = new ArrayList<>(3);
        names.add("John");
        names.add("John");
        names.add("Mary");

        List<PrayerPair> result = prayerDrawService.drawPrayerAssignments(names);

        assertNotNull(result);
        assertEquals(3, result.size());
    }

    @Test
    void getInstance_ShouldReturnSameInstance() {
        PrayerDrawService instance1 = PrayerDrawServiceImpl.getInstance();
        PrayerDrawService instance2 = PrayerDrawServiceImpl.getInstance();

        assertSame(instance1, instance2);
    }
}

package dev.guedes.prayforoneanother.services;

import com.google.inject.Inject;
import dev.guedes.prayforoneanother.models.PrayerPair;
import dev.guedes.prayforoneanother.services.impl.PrayerDrawServiceImpl;
import extensions.GuiceJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test class for {@link PrayerDrawServiceImpl}.
 * Verifies that the service correctly assigns prayer pairs with proper validation.
 *
 * @author João Guedes
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

        assertEquals("João", pair.getPrayerPerson().getName());
        assertEquals("João", pair.getRecipientPerson().getName());
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
}

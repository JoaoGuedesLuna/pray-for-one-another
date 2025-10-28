package dev.guedes.prayforoneanother.services;

import dev.guedes.prayforoneanother.models.PrayerPair;
import java.util.List;

/**
 * Service interface for drawing prayer assignments among a group of people.
 * Defines the contract for generating pairs where each person prays for another.
 *
 * @author João Guedes
 */
public interface PrayerDrawService {
    List<PrayerPair> drawPrayerAssignments(List<String> names);
}

package dev.guedes.prayforoneanother.models;

import lombok.Getter;

/**
 * Represents a prayer partnership between two persons.
 * One person prays for another in this bidirectional relationship.
 *
 * @author João Guedes
 */
@Getter
public class PrayerPair {
    private final Person prayerPerson;
    private final Person recipientPerson;

    public PrayerPair(Person prayerPerson, Person recipientPerson) {
        this.prayerPerson = prayerPerson;
        this.recipientPerson = recipientPerson;
    }
}

package dev.guedes.prayforoneanother.models;


/**
 * Represents a prayer partnership between two persons.
 * One person prays for another in this bidirectional relationship.
 *
 * @author João Guedes
 */
public class PrayerPair {
    private final Person prayerPerson;
    private final Person recipientPerson;

    public PrayerPair(Person prayerPerson, Person recipientPerson) {
        this.prayerPerson = prayerPerson;
        this.recipientPerson = recipientPerson;
    }

    public Person getPrayerPerson() { return prayerPerson; }
    public Person getRecipientPerson() { return recipientPerson; }
}

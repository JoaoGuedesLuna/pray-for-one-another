package dev.guedes.prayforoneanother.models;

import lombok.Getter;

/**
 * Represents a person entity.
 * This class is used to model individuals participating in the prayer initiative.
 *
 * @author João Guedes
 */
@Getter
public class Person {
    private final String name;

    public Person(String name) { this.name = name; }
}

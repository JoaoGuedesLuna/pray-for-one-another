package dev.guedes.prayforoneanother.exceptions;

/**
 * Domain-specific exception thrown when a person name fails validation.
 *
 * @author João Guedes
 */
public class InvalidNameException extends RuntimeException {
    public InvalidNameException() { super("Invalid name provided."); }
}

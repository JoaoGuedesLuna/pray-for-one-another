package dev.guedes.prayforoneanother.exceptions;

/**
 * Exception thrown when a null argument is provided where it is not allowed.
 *
 * @author João Guedes
 */
public class NullArgumentException extends RuntimeException {
    public NullArgumentException() { super("Argument must not be null."); }
}

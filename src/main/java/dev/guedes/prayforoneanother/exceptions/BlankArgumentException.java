package dev.guedes.prayforoneanother.exceptions;

/**
 * Exception thrown when a blank string argument is provided where it is not allowed.
 *
 * @author João Guedes
 */
public class BlankArgumentException extends RuntimeException {
    public BlankArgumentException() { super("Argument must not be blank."); }
}

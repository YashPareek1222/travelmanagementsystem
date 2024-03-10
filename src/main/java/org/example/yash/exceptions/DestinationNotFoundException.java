package org.example.yash.exceptions;

/**
 * Exception thrown when a destination is not found.
 */
public class DestinationNotFoundException extends RuntimeException{

    /**
     * Constructs a new DestinationNotFoundException with the specified detail message.
     *
     * @param message The detail message.
     */
    public DestinationNotFoundException (String message) {
        super(message);
    }
}

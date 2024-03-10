package org.example.yash.exceptions;

/**
 * Exception thrown when a passenger is not found.
 */
public class PassengerNotFoundException extends RuntimeException{

    /**
     * Constructs a new PassengerNotFoundException with the specified detail message.
     *
     * @param message The detail message.
     */
    public PassengerNotFoundException(String message) {
        super(message);
    }
}

package org.example.yash.exceptions;

/**
 * Exception thrown when an activity's capacity is full and cannot accept more participants.
 */
public class ActivityFullException extends RuntimeException{

    /**
     * Constructs a new ActivityFullException with the specified detail message.
     *
     * @param message The detail message.
     */
    public ActivityFullException(String message) {
        super(message);
    }
}

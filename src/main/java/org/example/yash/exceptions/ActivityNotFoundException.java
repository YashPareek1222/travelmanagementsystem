package org.example.yash.exceptions;

/**
 * Exception thrown when an activity is not found.
 */
public class ActivityNotFoundException extends RuntimeException{

    /**
     * Constructs a new ActivityNotFoundException with the specified detail message.
     *
     * @param message The detail message.
     */
    public ActivityNotFoundException (String message) {
        super(message);
    }
}

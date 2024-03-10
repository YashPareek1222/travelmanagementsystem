package org.example.yash.exceptions;

/**
 * Exception thrown when a travel package has reached its maximum capacity and cannot accept more passengers.
 */
public class TravelPackageFullException extends RuntimeException{

    /**
     * Constructs a new TravelPackageFullException with the specified detail message.
     *
     * @param message The detail message.
     */
    public TravelPackageFullException(String message) {
        super(message);
    }
}

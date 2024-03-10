package org.example.yash.exceptions;

/**
 * Exception thrown when a passenger's balance is insufficient for an operation.
 */
public class InsufficientBalanceException extends RuntimeException {

    /**
     * Constructs a new InsufficientBalanceException with the specified detail message.
     *
     * @param message The detail message.
     */
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

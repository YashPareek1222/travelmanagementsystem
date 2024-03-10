package org.example.yash.model;

/**
 * Represents a passenger participating in a travel package.
 * Each passenger has a unique identifier, name, passenger number,
 * and a balance representing available funds.
 */
public abstract class Passenger {

    private String id;
    private String name;
    private String passengerNumber;
    double balance;

    /**
     * Constructs a passenger with the specified attributes.
     *
     * @param id The unique identifier of the passenger.
     * @param name The name of the passenger.
     * @param passengerNumber The passenger number.
     * @param balance The balance representing available funds for the passenger.
     */
    public Passenger(String id, String name, String passengerNumber, double balance) {
        this.id = id;
        this.name = name;
        this.passengerNumber = passengerNumber;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public String getPassengerNumber() {
        return passengerNumber;
    }

    public abstract void deductCost(double cost);
}

package org.example.yash.model;

/**
 * Represents a standard passenger participating in a travel package.
 * Standard passengers pay the full cost of activity participation.
 */
public class StandardPassenger extends Passenger{

    /**
     * Constructs a standard passenger with the specified attributes.
     *
     * @param id The unique identifier of the passenger.
     * @param name The name of the passenger.
     * @param passengerNumber The passenger number.
     * @param balance The balance representing available funds for the passenger.
     */
    public StandardPassenger(String id, String name, String passengerNumber, double balance) {
        super(id, name, passengerNumber, balance);
    }

    /**
     * Deducts the specified cost from the standard passenger's balance.
     *
     * @param cost The cost to deduct.
     */
    @Override
    public void deductCost(double cost) {
        balance -= cost;
    }
}

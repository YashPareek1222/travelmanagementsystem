package org.example.yash.model;

/**
 * Represents a gold passenger participating in a travel package.
 * Gold passengers receive a 10% discount on activity costs.
 */
public class GoldPassenger extends Passenger{

    /**
     * Constructs a gold passenger with the specified attributes.
     *
     * @param id The unique identifier of the passenger.
     * @param name The name of the passenger.
     * @param passengerNumber The passenger number.
     * @param balance The balance representing available funds for the passenger.
     */
    public GoldPassenger(String id, String name, String passengerNumber, double balance) {
        super(id, name, passengerNumber, balance);
    }

    /**
     * Deducts the specified cost from the gold passenger's balance with a 10% discount.
     *
     * @param cost The cost to deduct.
     */
    @Override
    public void deductCost(double cost) {
        balance -= cost*0.9;
    }
}

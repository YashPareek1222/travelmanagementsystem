package org.example.yash.model;

/**
 * Represents a premium passenger participating in a travel package.
 * Premium passengers do not pay for activity costs.
 */
public class PremiumPassenger extends Passenger{

    /**
     * Constructs a premium passenger with the specified attributes.
     *
     * @param id The unique identifier of the passenger.
     * @param name The name of the passenger.
     * @param passengerNumber The passenger number.
     * @param balance The balance representing available funds for the passenger.
     */
    public PremiumPassenger(String id, String name, String passengerNumber, double balance) {
        super(id, name, passengerNumber, balance);
    }

    /**
     * Deducts the specified cost from the premium passenger's balance (always zero for premium passengers).
     *
     * @param cost The cost to deduct (ignored for premium passengers).
     */
    @Override
    public void deductCost(double cost) {
        // Premium passengers do not pay for activity costs
        // Balance remains unchanged
    }
}

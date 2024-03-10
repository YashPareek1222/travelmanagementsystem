package org.example.yash.dao;

import org.example.yash.exceptions.ActivityFullException;
import org.example.yash.exceptions.InsufficientBalanceException;
import org.example.yash.exceptions.PassengerNotFoundException;
import org.example.yash.model.Activity;
import org.example.yash.model.Passenger;
import org.example.yash.model.PremiumPassenger;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * The DAO (Data Access Object) class for managing passengers.
 * This class provides methods to add, retrieve, and enroll passengers in activities within the travel package.
 */
public class PassengerDao {

    /** The list of passengers enrolled in the travel package. */
    private List<Passenger> passengers;

    /** The manager responsible for mapping passengers to their signed-up activities. */
    private PassengerActivityMappingManager mappingManager;

    /**
     * Constructs a new PassengerDao with an empty list of passengers and a mapping manager.
     */
    public PassengerDao() {
        this.passengers = new ArrayList<>();
        this.mappingManager = new PassengerActivityMappingManager();

    }

    /**
     * Retrieves the number of passengers currently enrolled in the travel package.
     *
     * @return The number of passengers enrolled.
     */
    public int numberOfPassengersEnrolled() {
        return passengers.size();
    }

    /**
     * Adds a new passenger to the travel package.
     *
     * @param passenger The passenger to be added.
     */
    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }

    /**
     * Retrieves a passenger by their unique identifier.
     *
     * @param id The unique identifier of the passenger.
     * @return The passenger with the specified identifier.
     * @throws PassengerNotFoundException If no passenger is found with the given identifier.
     */
    public Passenger getPassengerById(String id) {
        for (Passenger passenger : passengers) {
            if (id.equals(passenger.getId())) {
                return passenger;
            }
        }
        throw new PassengerNotFoundException("No such Passenger found");
    }

    /**
     * Retrieves a list of all passengers enrolled in the travel package.
     *
     * @return A list of all passengers enrolled.
     */
    public List<Passenger> getAllPassengers() {
        return passengers;
    }

    /**
     * Retrieves the set of activities that a passenger has signed up for.
     *
     * @param passenger The passenger for whom to retrieve signed-up activities.
     * @return The set of activities that the passenger has signed up for.
     */
    public Set<Activity> getAllActivitiesPassengerSignedUp(Passenger passenger) {
        return mappingManager.getAllActivitiesPassengerSignedUp(passenger);
    }

    /**
     * Enrolls a passenger in an activity within the travel package.
     *
     * @param passenger The passenger to be enrolled.
     * @param activity The activity to be enrolled in.
     * @throws PassengerNotFoundException If the passenger is not found in the travel package.
     * @throws ActivityFullException If the activity's capacity is full.
     * @throws InsufficientBalanceException If the passenger has insufficient balance to cover the activity's cost.
     */
    public void enrollPassengerInActivity(Passenger passenger, Activity activity) throws RuntimeException {
        // Check if passenger is in the travel package
        if (!passengers.contains(passenger)) {
            throw new PassengerNotFoundException("Passenger not found in this package.");
        }
        // Check if activity capacity is full
        if (activity.getCapacity() <= 0) {
            throw new ActivityFullException("Activity is full.");
        }
        double cost = activity.getCost();
        deductCostForPassenger(passenger, cost);
        activity.decreaseCapacity();
        mappingManager.enrollPassengerToActivity(passenger, activity);
    }

    /**
     * Deducts the cost of an activity from the balance of the passenger, if applicable.
     *
     * @param passenger The passenger for whom the cost is being deducted.
     * @param cost The cost of the activity.
     * @throws InsufficientBalanceException If the passenger's balance is insufficient to cover the cost.
     */
    private void deductCostForPassenger(Passenger passenger, double cost) throws InsufficientBalanceException {
        if (!(passenger instanceof PremiumPassenger) && passenger.getBalance() < cost) {
            throw new InsufficientBalanceException("Insufficient balance.");
        }
        passenger.deductCost(cost);
    }
}

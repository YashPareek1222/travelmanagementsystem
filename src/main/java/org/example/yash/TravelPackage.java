package org.example.yash;

import org.example.yash.dao.ActivityDao;
import org.example.yash.dao.DestinationDao;
import org.example.yash.dao.PassengerDao;
import org.example.yash.exceptions.TravelPackageFullException;
import org.example.yash.model.Activity;
import org.example.yash.model.Destination;
import org.example.yash.model.Passenger;

import java.util.List;
import java.util.Set;

/**
 * Represents a travel package offered by a travel agency.
 * Each travel package has a unique identifier, name, description, and passenger capacity.
 * It includes various destinations, activities, and enrolled passengers.
 */
public class TravelPackage {

    private String id;
    private String name;
    private String description;
    private int passengerCapacity;
    private DestinationDao destinationDao;
    private ActivityDao activityDao;
    private PassengerDao passengerDao;

    /**
     * Constructs a travel package with the specified attributes.
     *
     * @param id The unique identifier of the travel package.
     * @param name The name of the travel package.
     * @param description The description of the travel package.
     * @param passengerCapacity The maximum capacity of passengers for the travel package.
     */
    public TravelPackage(String id, String name, String description, int passengerCapacity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.passengerCapacity = passengerCapacity;
        this.destinationDao = new DestinationDao();
        this.activityDao = new ActivityDao();
        this.passengerDao = new PassengerDao();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public List<Destination> getItineary() {
        return destinationDao.getAllDestinations();
    }

    public List<Passenger> getAllPassengers() {
        return passengerDao.getAllPassengers();
    }

    public List<Activity> getAllActivities() {
        return activityDao.getAllActivities();
    }

    public void addDestination(Destination destination) {
        destinationDao.addDestination(destination);
    }


    public void addActivity(Activity activity) {
        activityDao.addActivity(activity);
    }

    public void addPassengers(Passenger passenger) {
        if (numberofPassengersEnrolled() < passengerCapacity) {
            passengerDao.addPassenger(passenger);
        }
        else {
            throw new TravelPackageFullException("The travel package is completely booked. No more passengers can be added.");
        }
    }

    public void enrollPassengerInActivity(Passenger passenger, Activity activity) {
        passengerDao.enrollPassengerInActivity(passenger, activity);
    }

    public int numberofPassengersEnrolled() {
        return passengerDao.numberOfPassengersEnrolled();
    }

    public Set<Activity> getAllSignedUpActivities(Passenger passenger) {
        return passengerDao.getAllActivitiesPassengerSignedUp(passenger);
    }

    public List<Activity> getAllAvailableActivities() {
        return activityDao.getAvailableActivities();
    }
}

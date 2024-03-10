package org.example.yash.dao;

import org.example.yash.model.Activity;
import org.example.yash.model.Passenger;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Manages the mapping of passengers to their signed-up activities.
 */
public class PassengerActivityMappingManager {

    /** The mapping of passengers to their signed-up activities. */
    private Map<Passenger, Set<Activity>> signedUpActivities;

    /**
     * Constructs a new PassengerActivityMappingManager with an empty mapping.
     */
    public PassengerActivityMappingManager() {
        this.signedUpActivities = new HashMap<>();
    }

    /**
     * Enrolls a passenger in an activity.
     *
     * @param passenger The passenger to be enrolled.
     * @param activity The activity to be enrolled in.
     */
    public void enrollPassengerToActivity(Passenger passenger, Activity activity) {
        signedUpActivities.computeIfAbsent(passenger, k -> new HashSet<>()).add(activity);
    }

    /**
     * Retrieves all activities that a passenger has signed up for.
     *
     * @param passenger The passenger whose signed-up activities are to be retrieved.
     * @return The set of activities that the passenger has signed up for.
     */
    public Set<Activity> getAllActivitiesPassengerSignedUp(Passenger passenger) {
        return signedUpActivities.getOrDefault(passenger, new HashSet<>());
    }

}

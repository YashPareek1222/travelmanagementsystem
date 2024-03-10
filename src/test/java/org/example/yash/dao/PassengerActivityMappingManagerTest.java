package org.example.yash.dao;

import org.example.yash.model.Activity;
import org.example.yash.model.Destination;
import org.example.yash.model.GoldPassenger;
import org.example.yash.model.Passenger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PassengerActivityMappingManagerTest {

    private PassengerActivityMappingManager mappingManager;
    private Passenger passenger;
    private Activity activity1;
    private Activity activity2;

    private Destination destination;

    @BeforeEach
    public void setUp() {
        mappingManager = new PassengerActivityMappingManager();
        passenger = new GoldPassenger("1", "John Doe", "102", 200.0);
        destination = new Destination("1", "Mountain Resort");
        activity1 = new Activity("1", "Hiking",
                "Enjoy a hike through scenic trails", 50.0, 3, destination);
        activity2 = new Activity("2", "Sightseeing Tour",
                "Explore famous landmarks in the city", 100.0, 15, destination);
    }

    @Test
    public void testEnrollPassengerToActivity() {
        mappingManager.enrollPassengerToActivity(passenger, activity1);
        Set<Activity> signedUpActivities = mappingManager.getAllActivitiesPassengerSignedUp(passenger);
        assertEquals(1, signedUpActivities.size());
        assertTrue(signedUpActivities.contains(activity1));
    }

    @Test
    public void testGetAllActivitiesPassengerSignedUp() {
        mappingManager.enrollPassengerToActivity(passenger, activity1);
        mappingManager.enrollPassengerToActivity(passenger, activity2);
        Set<Activity> signedUpActivities = mappingManager.getAllActivitiesPassengerSignedUp(passenger);
        assertEquals(2, signedUpActivities.size());
        assertTrue(signedUpActivities.contains(activity1));
        assertTrue(signedUpActivities.contains(activity2));
    }
}


package org.example.yash;

import org.example.yash.exceptions.TravelPackageFullException;
import org.example.yash.model.Activity;
import org.example.yash.model.Destination;
import org.example.yash.model.GoldPassenger;
import org.example.yash.model.Passenger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TravelPackageTest {

    private static TravelPackage travelPackage;

    @BeforeEach
    public void setUp() {
        travelPackage = new TravelPackage("1", "Adventure Tour", "Explore city", 20);
    }

    @Test
    public void testAddDestination() {
        Destination destination = new Destination("1", "Mountain Resort");
        travelPackage.addDestination(destination);
        assertEquals(1, travelPackage.getItineary().size());
    }

    @Test
    public void testAddActivity() {
        Destination destination = new Destination("1", "Mountain Resort");
        Activity activity = new Activity("1", "Hiking",
                "Enjoy a hike through scenic trails", 50.0, 3, destination);
        travelPackage.addActivity(activity);
        assertEquals(1, travelPackage.getAllActivities().size());
    }

    @Test
    public void testAddPassengers() {
        Passenger passenger = new GoldPassenger("1P", "Alice", "101", 200.0);
        travelPackage.addPassengers(passenger);
        assertEquals(1, travelPackage.numberofPassengersEnrolled());
    }

    @Test
    public void testAddPassengersWhenPackageIsFull() {
        for (int i = 0; i < 20; i++) {
            Passenger passenger = new GoldPassenger("P" + i, "Passenger" + i, "101", 200.0);
            travelPackage.addPassengers(passenger);
        }
        assertThrows(TravelPackageFullException.class, () -> {
            Passenger extraPassenger = new GoldPassenger("ExtraP", "Extra Passenger", "101", 200.0);
            travelPackage.addPassengers(extraPassenger);
        });
    }

    @Test
    public void testEnrollPassengerInActivity() {
        Destination destination = new Destination("1", "Mountain Resort");
        Passenger passenger = new GoldPassenger("1P", "Alice", "101", 200.0);
        Activity activity = new Activity("1", "Hiking",
                "Enjoy a hike through scenic trails", 50.0, 3, destination);
        travelPackage.addPassengers(passenger);
        travelPackage.enrollPassengerInActivity(passenger, activity);
        assertTrue(travelPackage.getAllSignedUpActivities(passenger).contains(activity));
    }

    @Test
    public void testGetAllAvailableActivities() {
        Destination destination1 = new Destination("1", "Mountain Resort");
        Destination destination2 = new Destination("2", "City Tour");
        Activity activity1 = new Activity("1", "Hiking",
                "Enjoy a hike through scenic trails", 50.0, 1, destination1);
        Activity activity2 = new Activity("2", "Sightseeing Tour",
                "Explore famous landmarks in the city", 100.0, 15, destination2);
        Passenger passenger = new GoldPassenger("1P", "Alice", "101", 200.0);
        travelPackage.addActivity(activity1);
        travelPackage.addActivity(activity2);
        travelPackage.addPassengers(passenger);
        travelPackage.enrollPassengerInActivity(passenger, activity1);
        assertEquals(1, travelPackage.getAllAvailableActivities().size());
    }
}

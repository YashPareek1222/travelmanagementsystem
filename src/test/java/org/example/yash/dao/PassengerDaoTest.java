package org.example.yash.dao;

import org.example.yash.exceptions.ActivityFullException;
import org.example.yash.exceptions.InsufficientBalanceException;
import org.example.yash.exceptions.PassengerNotFoundException;
import org.example.yash.model.Activity;
import org.example.yash.model.Destination;
import org.example.yash.model.GoldPassenger;
import org.example.yash.model.Passenger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PassengerDaoTest {

    private PassengerDao passengerDao;
    private Activity activity;
    private Passenger passenger;

    private Destination destination;

    @BeforeEach
    public void setUp() {
        passengerDao = new PassengerDao();
        destination = new Destination("1", "Mountain Resort");
        activity = new Activity("1", "Hiking",
                "Enjoy a hike through scenic trails", 50.0, 3, destination);
        passenger = new GoldPassenger("1", "John Doe", "102", 50.0);
    }

    @Test
    public void testNumberOfPassengersEnrolled() {
        assertEquals(0, passengerDao.numberOfPassengersEnrolled());
    }

    @Test
    public void testAddPassenger() {
        passengerDao.addPassenger(passenger);
        assertEquals(1, passengerDao.numberOfPassengersEnrolled());
        assertTrue(passengerDao.getAllPassengers().contains(passenger));
    }

    @Test
    public void testGetPassengerById() {
        passengerDao.addPassenger(passenger);
        assertEquals(passenger, passengerDao.getPassengerById("1"));
    }

    @Test
    public void testGetPassengerByIdNotFound() {
        assertThrows(PassengerNotFoundException.class, () -> passengerDao.getPassengerById("2"));
    }

    @Test
    public void testGetAllPassengers() {
        Passenger passenger2 = new GoldPassenger("2", "Yash Pareek", "103", 500.0);;
        passengerDao.addPassenger(passenger);
        passengerDao.addPassenger(passenger2);
        List<Passenger> passengers = passengerDao.getAllPassengers();
        assertEquals(2, passengers.size());
        assertTrue(passengers.contains(passenger));
        assertTrue(passengers.contains(passenger2));
    }

    @Test
    public void testEnrollPassengerInActivity() {
        activity.setCapacity(1);
        passengerDao.addPassenger(passenger);
        passengerDao.enrollPassengerInActivity(passenger, activity);
        assertEquals(1, passengerDao.getAllActivitiesPassengerSignedUp(passenger).size());
    }

    @Test
    public void testEnrollPassengerInActivityPassengerNotFound() {
        assertThrows(PassengerNotFoundException.class, () -> passengerDao.enrollPassengerInActivity(passenger, activity));
    }

    @Test
    public void testEnrollPassengerInActivityActivityFull() {
        activity.setCapacity(0);
        passengerDao.addPassenger(passenger);
        assertThrows(ActivityFullException.class, () -> passengerDao.enrollPassengerInActivity(passenger, activity));
    }

    @Test
    public void testEnrollPassengerInActivityInsufficientBalance() {
        activity.setCost(100);
        activity.setCapacity(1);
        passengerDao.addPassenger(passenger);
        assertThrows(InsufficientBalanceException.class, () -> passengerDao.enrollPassengerInActivity(passenger, activity));
    }
}


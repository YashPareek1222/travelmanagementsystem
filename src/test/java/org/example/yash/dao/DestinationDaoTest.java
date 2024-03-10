package org.example.yash.dao;

import org.example.yash.exceptions.DestinationNotFoundException;
import org.example.yash.model.Destination;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DestinationDaoTest {

    private DestinationDao destinationDao;

    @BeforeEach
    public void setUp() {
        destinationDao = new DestinationDao();
    }

    @Test
    public void testAddDestination() {
        Destination destination = new Destination("1", "Mountain Resort");
        destinationDao.addDestination(destination);
        assertEquals(1, destinationDao.getAllDestinations().size());
    }

    @Test
    public void testGetDestinationById() {
        Destination destination = new Destination("1", "Mountain Resort");
        destinationDao.addDestination(destination);
        assertEquals(destination, destinationDao.getDestinationById("1"));
    }

    @Test
    public void testGetDestinationByIdNotFound() {
        assertThrows(DestinationNotFoundException.class, () -> destinationDao.getDestinationById("999"));
    }

    @Test
    public void testGetAllDestinations() {
        Destination destination1 = new Destination("1", "Mountain Resort");
        Destination destination2 = new Destination("2", "City Tour");
        destinationDao.addDestination(destination1);
        destinationDao.addDestination(destination2);
        List<Destination> allDestinations = destinationDao.getAllDestinations();
        assertEquals(2, allDestinations.size());
        assertTrue(allDestinations.contains(destination1));
        assertTrue(allDestinations.contains(destination2));
    }
}


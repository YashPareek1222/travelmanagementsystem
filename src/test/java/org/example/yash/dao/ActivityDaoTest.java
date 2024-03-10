package org.example.yash.dao;

import org.example.yash.model.Activity;
import org.example.yash.exceptions.ActivityNotFoundException;
import org.example.yash.model.Destination;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ActivityDaoTest {

    private ActivityDao activityDao;

    @BeforeEach
    public void setUp() {
        activityDao = new ActivityDao();
    }

    @Test
    public void testAddActivity() {
        Destination destination = new Destination("1", "Mountain Resort");
        Activity activity = new Activity("1", "Hiking",
                "Enjoy a hike through scenic trails", 50.0, 3, destination);
        activityDao.addActivity(activity);
        assertEquals(1, activityDao.getAllActivities().size());
    }

    @Test
    public void testGetActivityById() {
        Destination destination = new Destination("1", "Mountain Resort");
        Activity activity = new Activity("1", "Hiking",
                "Enjoy a hike through scenic trails", 50.0, 3, destination);
        activityDao.addActivity(activity);
        assertEquals(activity, activityDao.getActivityById("1"));
    }

    @Test
    public void testGetActivityByIdNotFound() {
        assertThrows(ActivityNotFoundException.class, () -> activityDao.getActivityById("999"));
    }

    @Test
    public void testGetAllActivities() {
        Destination destination = new Destination("1", "Mountain Resort");
        Activity activity1 = new Activity("1", "Hiking",
                "Enjoy a hike through scenic trails", 50.0, 3, destination);
        Activity activity2 = new Activity("2", "Sightseeing Tour",
                "Explore famous landmarks in the city", 100.0, 15, destination);
        activityDao.addActivity(activity1);
        activityDao.addActivity(activity2);
        List<Activity> allActivities = activityDao.getAllActivities();
        assertEquals(2, allActivities.size());
        assertTrue(allActivities.contains(activity1));
        assertTrue(allActivities.contains(activity2));
    }

    @Test
    public void testGetAvailableActivities() {
        Destination destination = new Destination("1", "Mountain Resort");
        Activity activity1 = new Activity("1", "Hiking",
                "Enjoy a hike through scenic trails", 50.0, 3, destination);
        Activity activity2 = new Activity("2", "Sightseeing Tour",
                "Explore famous landmarks in the city", 100.0, 0, destination);
        activityDao.addActivity(activity1);
        activityDao.addActivity(activity2);
        List<Activity> availableActivities = activityDao.getAvailableActivities();
        assertEquals(1, availableActivities.size());
        assertTrue(availableActivities.contains(activity1));
    }
}

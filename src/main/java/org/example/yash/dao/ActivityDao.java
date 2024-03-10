package org.example.yash.dao;

import org.example.yash.exceptions.ActivityNotFoundException;
import org.example.yash.model.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * The DAO (Data Access Object) class for managing activities.
 * This class provides methods to add, retrieve, and query activities.
 */
public class ActivityDao {

    private List<Activity> activities;

    // Constructor
    public ActivityDao() {
        this.activities = new ArrayList<>();
    }

    /**
     * Adds a new activity to the DAO.
     *
     * @param activity The activity to be added.
     */
    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    /**
     * Retrieves an activity by its unique identifier.
     *
     * @param id The unique identifier of the activity.
     * @return The activity with the specified identifier.
     * @throws ActivityNotFoundException If no activity is found with the given identifier.
     */
    public Activity getActivityById(String id) {
        for (Activity activity : activities) {
            if (id.equals(activity.getId())) {
                return activity;
            }
        }
        throw new ActivityNotFoundException("No such Activity found");
    }

    /**
     * Retrieves a list of all activities managed by the DAO.
     *
     * @return A list of all activities.
     */
    public List<Activity> getAllActivities() {
        return activities;
    }

    /**
     * Retrieves a list of activities that still have available slots.
     *
     * @return A list of activities with available slots.
     */
    public List<Activity> getAvailableActivities() {
        List<Activity> activityList = new ArrayList<>();
        for (Activity activity : activities) {
            if (activity.getCapacity()>0) {
                activityList.add(activity);
            }
        }
        return activityList;
    }
}

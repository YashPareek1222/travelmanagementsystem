package org.example.yash.model;

/**
 * Represents an activity within a travel package itinerary.
 * Each activity has a unique identifier, name, description, cost, capacity,
 * and a destination where the activity takes place.
 */
public class Activity {

    private String id;
    private String name;
    private String description;
    private double cost;
    private int capacity;
    private Destination destination;

    /**
     * Constructs an activity with the specified attributes.
     *
     * @param id The unique identifier of the activity.
     * @param name The name of the activity.
     * @param description The description of the activity.
     * @param cost The cost of participating in the activity.
     * @param capacity The maximum capacity of participants for the activity.
     * @param destination The destination where the activity takes place.
     */
    public Activity(String id, String name, String description, double cost, int capacity, Destination destination) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.capacity = capacity;
        this.destination = destination;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
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

    public double getCost() {
        return cost;
    }

    public int getCapacity() {
        return capacity;
    }

    public void decreaseCapacity() {
        capacity--;
    }
    public Destination getDestination() {
        return destination;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                ", capacity=" + capacity +
                ", destination=" + destination +
                '}' + "\n";
    }
}

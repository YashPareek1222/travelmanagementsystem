package org.example.yash.model;

/**
 * Represents a destination included in a travel package itinerary.
 * Each destination is characterized by a unique identifier and a name.
 */
public class Destination {

    private String id;
    private String name;

    /**
     * Constructs a destination with the specified attributes.
     *
     * @param id The unique identifier of the activity.
     * @param name The name of the activity.
     */
    public Destination(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Destination{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

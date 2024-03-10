package org.example.yash.dao;

import org.example.yash.exceptions.DestinationNotFoundException;
import org.example.yash.model.Destination;

import java.util.ArrayList;
import java.util.List;

/**
 * The DAO (Data Access Object) class for managing destinations.
 * This class provides methods to add, retrieve, and query destinations.
 */
public class DestinationDao {

    /** The list of destinations in the travel package. */
    private List<Destination> destinations;

    // Constructor
    public DestinationDao() {
        this.destinations = new ArrayList<>();
    }

    /**
     * Adds a new destination to the travel package.
     *
     * @param destination The destination to be added.
     */
    public void addDestination(Destination destination) {
        destinations.add(destination);
    }

    /**
     * Retrieves a destination by its unique identifier.
     *
     * @param id The unique identifier of the destination.
     * @return The destination with the specified identifier.
     * @throws DestinationNotFoundException If no destination is found with the given identifier.
     */
    public Destination getDestinationById(String id) {
        for (Destination destination : destinations) {
            if (id.equals(destination.getId())) {
                return destination;
            }
        }
        throw new DestinationNotFoundException("No such Destination found");
    }

    /**
     * Retrieves a list of all destinations managed by the DAO.
     *
     * @return A list of all destinations.
     */
    public List<Destination> getAllDestinations() {
        return destinations;
    }
}

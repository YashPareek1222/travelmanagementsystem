package org.example.yash;

import org.example.yash.model.Activity;
import org.example.yash.model.Destination;
import org.example.yash.model.Passenger;
import org.example.yash.model.StandardPassenger;
import org.example.yash.model.GoldPassenger;
import org.example.yash.model.PremiumPassenger;

/**
 * The Main class contains the main method to demonstrate the functionality of the travel package management system.
 * It initializes a travel package, populates it with destinations, activities, and passengers,
 * and performs various operations such as printing the itinerary, passenger list, passenger details,
 * and available activities.
 */
public class Main {

    /**
     * The main method creates and initializes a travel package, populates it with data,
     * and demonstrates various operations.
     *
     * @param args The command-line arguments (not used).
     */
    public static void main(String[] args) {

        // Create and initialize a travel package
        TravelPackage travelPackage = createTravelPackage("1", "Adventure Tour",
                "Explore city", 20);

        // Initialize data for the travel package
        initializeData(travelPackage);

        // Print itinerary of the travel package
        System.out.println("Itineary ->");
        printItinerary(travelPackage);

        // Print passenger list of the travel package
        System.out.println("Passenger List ->");
        printPassengerList(travelPackage);

        // Print details of each passenger in the travel package
        System.out.println("Passenger Details ->");
        printPassengerDetails(travelPackage);

        // Print details of available activities in the travel package
        System.out.println("Available Activities ->");
        printAvailableActivities(travelPackage);

    }
    private static void initializeData(TravelPackage travelPackage) {

        // Create destinations
        Destination destination1 = new Destination("1", "Mountain Resort");
        Destination destination2 = new Destination("2", "City Tour");
        travelPackage.addDestination(destination1);
        travelPackage.addDestination(destination2);

        // Create activities
        Activity activity1 = new Activity("1", "Hiking", "Enjoy a hike through scenic trails", 50.0, 3, destination1);
        Activity activity2 = new Activity("2", "Sightseeing Tour", "Explore famous landmarks in the city", 100.0, 15, destination2);
        travelPackage.addActivity(activity1);
        travelPackage.addActivity(activity2);

        // Create passengers
        Passenger passenger1 = new StandardPassenger("1P", "Alice", "101", 200.0);
        Passenger passenger2 = new GoldPassenger("2P", "Bob", "102", 300.0);
        Passenger passenger3 = new PremiumPassenger("3P", "Charlie", "103", 0.0);
        travelPackage.addPassengers(passenger1);
        travelPackage.addPassengers(passenger2);
        travelPackage.addPassengers(passenger3);

        // Enroll passenger to activities
        travelPackage.enrollPassengerInActivity(passenger1, activity1);
        travelPackage.enrollPassengerInActivity(passenger2, activity1);
        travelPackage.enrollPassengerInActivity(passenger3, activity2);

    }

    private static TravelPackage createTravelPackage(String id, String name,
                                                     String description, int capacity) {
        return new TravelPackage(id, name, description, capacity);
    }

    private static void printItinerary(TravelPackage travelPackage) {
        // destinationDao and activityDao to fetch destinations and activities.
        System.out.println("Travel Package: " + travelPackage.getName());
        System.out.println("--------------------");
        for (Destination destination : travelPackage.getItineary()) {
            System.out.println("Destination: " + destination.getName());
            for (Activity activity : travelPackage.getAllActivities()) {
                System.out.println("Activity: " + activity.getName() + ", Cost: " + activity.getCost() + ", Capacity: " + activity.getCapacity() + ", Description: " + activity.getDescription());
            }
            System.out.println("--------------------");
        }
        System.out.println("\n\n\n\n");
    }

    private static void printPassengerList(TravelPackage travelPackage) {
        System.out.println("Travel Package: " + travelPackage.getName());
        System.out.println("--------------------");
        System.out.println("Passenger Capacity: " + travelPackage.getPassengerCapacity());
        System.out.println("Number of passengers enrolled: " + travelPackage.numberofPassengersEnrolled());
        for (Passenger passenger : travelPackage.getAllPassengers()) {
            System.out.println("Passenger Name: " + passenger.getName() + ", Passenger Number: " + passenger.getPassengerNumber());
        }
        System.out.println("\n\n\n\n");
    }

    private static void printPassengerDetails(TravelPackage travelPackage) {
        for (Passenger passenger : travelPackage.getAllPassengers()) {
            System.out.println("Passenger Name: " + passenger.getName() + "," +
                    "Passenger Number: " + passenger.getPassengerNumber() + "," +
                    "Passenger balance: " + passenger.getBalance() + "," +
                    "Activities signedup: " + travelPackage.getAllSignedUpActivities(passenger));
        }
        System.out.println("\n\n\n\n");
    }

    private static void printAvailableActivities(TravelPackage travelPackage) {
        System.out.println(travelPackage.getAllAvailableActivities());
    }
}
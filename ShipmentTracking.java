//-----------------------------------------------------
// Title: Shipment Tracking
// Author: Mahmut Emre Demir
// ID: 59344436266
// Section: 2
// Assignment: 4
// Description: This class stores all the shipments in a priority queue and a current time object.
// scheduleShipment() method is used to add a shipment to the priority queue.
// startShipment() method is used to print the shipment that is currently being processed.
// completeShipment() method is used to print the shipment that is completed.
// runTime() method is used to simulate the shipment process. It takes the time as a parameter and processes the shipments accordingly.
//-----------------------------------------------------

import java.util.PriorityQueue;

public class ShipmentTracking {
    private static PriorityQueue<Shipment> allShipments = new PriorityQueue<Shipment>(new ShipmentComparator());
    private static Long currentTime = 0L;


    public static PriorityQueue<Shipment> getAllShipments() {
        return allShipments;
    }

    public static void setAllShipments(PriorityQueue<Shipment> allShipments) {
        ShipmentTracking.allShipments = allShipments;
    }

    public static Long getCurrentTime() {
        return currentTime;
    }

    public static void setCurrentTime(Long currentTime) {
        ShipmentTracking.currentTime = currentTime;
    }

    public static void runTime(Long time) {
        Long remainingTime = time;

        // Firstly, checking if there are any shipments to process
        if (!getAllShipments().isEmpty()) {

            // Processing the shipments until there's no time left or no shipments left
            while (remainingTime > 0 && !getAllShipments().isEmpty()) {
                // Getting the shipment with the earliest deadline and creating a new shipment object
                Shipment shipment = getAllShipments().poll();
                if (shipment != null) {
                    // Starting the shipment
                    startShipment(shipment);
                    // Checking if there is enough time to complete the shipment
                    if (shipment.getDuration() <= remainingTime) {
                        // If there is enough time completing the shipment and updating the remaining time
                        setCurrentTime(getCurrentTime() + shipment.getDuration());
                        completeShipment(shipment);
                        remainingTime -= shipment.getDuration();
                    } else {
                        // If there is not enough time to complete the shipment updating the remaining time and adding the shipment back to the queue
                        setCurrentTime(getCurrentTime() + remainingTime);
                        scheduleShipment(new Shipment(shipment.getName(), shipment.getDeadLine(), shipment.getDuration() - remainingTime));
                        break; // Breaking the loop since there is not enough time to complete this shipment
                    }
                }
            }
        }
    }


    public static void scheduleShipment(Shipment shipment) {
        getAllShipments().add(shipment);
        System.out.println(getCurrentTime() + ": adding " + shipment.toString());
    }

    public static void startShipment(Shipment shipment) {
        System.out.println(getCurrentTime() + ": busy with " + shipment.toString());
    }

    public static void completeShipment(Shipment shipment) {
        System.out.println(getCurrentTime() + ": done with " + shipment.getName());
    }
}

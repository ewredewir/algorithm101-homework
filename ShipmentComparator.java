//-----------------------------------------------------
// Title: Shipment Comparator
// Author: Mahmut Emre Demir
// ID: 59344436266
// Section: 2
// Assignment: 4
// Description: This class compares the shipments according to their deadlines. It implements Comparator interface and overrides compare method.
// compare method is used to store the shipments in a priority queue according to their deadlines.
//-----------------------------------------------------

import java.util.Comparator;

public class ShipmentComparator implements Comparator<Shipment> {
    @Override
    public int compare(Shipment s1, Shipment s2) {
        if (s1.getDeadLine() > s2.getDeadLine()) {
            return 1;
        } else if (s1.getDeadLine() < s2.getDeadLine()) {
            return -1;
        } else {
            return 0;
        }
    }
}

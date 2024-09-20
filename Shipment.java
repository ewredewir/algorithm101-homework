//-----------------------------------------------------
// Title: Shipment Class
// Author: Mahmut Emre Demir
// ID: 59344436266
// Section: 2
// Assignment: 4
// Description: This class contains the shipment object with name, deadline and duration. Also, it has an overridden toString method to print the shipment object accordingly.
//-----------------------------------------------------

public class Shipment {
    private String name;
    private Long deadLine;
    private Long duration;

    public Shipment(String name, Long deadLine, Long duration) {
        this.name = name;
        this.deadLine = deadLine;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(Long deadLine) {
        this.deadLine = deadLine;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return getName() + " with deadline " + getDeadLine() + " and duration " + getDuration();
    }
}

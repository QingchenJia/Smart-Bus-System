package SmartBusSystem.pojo;

import java.sql.Time;

public class Route {
    private String ID;
    private String name;
    private int status;
    private Time startTime;
    private Time endTime;
    private double price;

    public Route() {
    }

    public Route(String ID, String name, int status, Time startTime, Time endTime, double price) {
        this.ID = ID;
        this.name = name;
        this.status = status;
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Route{" + "ID='" + ID + '\'' + ", name='" + name + '\'' + ", status=" + status + ", startTime=" + startTime + ", endTime=" + endTime + ", price=" + price + '}';
    }
}

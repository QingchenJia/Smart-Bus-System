package SmartBusSystem.pojo;

import lombok.Getter;
import lombok.Setter;

import java.sql.Time;

@Setter
@Getter
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

    @Override
    public String toString() {
        return "Route{" + "ID='" + ID + '\'' + ", name='" + name + '\'' + ", status=" + status + ", startTime=" + startTime + ", endTime=" + endTime + ", price=" + price + '}';
    }
}

package SmartBusSystem.pojo.mediator;

import SmartBusSystem.pojo.Bus;
import SmartBusSystem.pojo.Driver;
import SmartBusSystem.pojo.Route;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WorkArrangeRow {
    private String dayOfWeek;
    private Bus bus;
    private Route route;
    private Driver driver;

    public WorkArrangeRow() {
    }

    public WorkArrangeRow(String dayOfWeek, Bus bus, Route route, Driver driver) {
        this.dayOfWeek = dayOfWeek;
        this.bus = bus;
        this.route = route;
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "WorkArrangeRow{" +
                "dayOfWeek='" + dayOfWeek + '\'' +
                ", bus=" + bus +
                ", route=" + route +
                ", driver=" + driver +
                '}';
    }
}

package SmartBusSystem.service.TableRow;

import SmartBusSystem.pojo.Bus;
import SmartBusSystem.pojo.Driver;
import SmartBusSystem.pojo.Route;

public class WorkArrangeRow {
    private String dayOfWeek;
    private Bus bus;
    private Route route;
    private Driver driver;

    public WorkArrangeRow(String dayOfWeek, Bus bus, Route route, Driver driver) {
        this.dayOfWeek = dayOfWeek;
        this.bus = bus;
        this.route = route;
        this.driver = driver;
    }

    public WorkArrangeRow() {
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "WorkArrangeRow{" + "dayOfWeek='" + dayOfWeek + '\'' + ", driver=" + driver + ", bus=" + bus + ", route=" + route + '}';
    }
}

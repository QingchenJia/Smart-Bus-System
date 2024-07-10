package SmartBusSystem.service.TableRow;

import SmartBusSystem.pojo.Bus;
import SmartBusSystem.pojo.Route;

public class WorkArrangeRow {
    private String dayOfWeek;
    private Bus bus;
    private Route route;

    public WorkArrangeRow() {
    }

    public WorkArrangeRow(String dayOfWeek, Bus bus, Route route) {
        this.dayOfWeek = dayOfWeek;
        this.bus = bus;
        this.route = route;
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

    @Override
    public String toString() {
        return "WorkArrangeRow{" +
                "dayOfWeek='" + dayOfWeek + '\'' +
                ", bus=" + bus +
                ", route=" + route +
                '}';
    }
}

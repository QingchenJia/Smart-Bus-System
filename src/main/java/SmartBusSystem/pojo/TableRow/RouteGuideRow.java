package SmartBusSystem.pojo.TableRow;

import SmartBusSystem.pojo.Stop;

import java.util.List;

public class RouteGuideRow {
    private String routeId;
    private String routeName;
    private List<Stop> stops;

    public RouteGuideRow() {
    }

    public RouteGuideRow(String routeId, String routeName, List<Stop> stops) {
        this.routeId = routeId;
        this.routeName = routeName;
        this.stops = stops;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public List<Stop> getStops() {
        return stops;
    }

    public void setStopNames(List<Stop> stops) {
        this.stops = stops;
    }

    @Override
    public String toString() {
        return "RouteGuideRow{" + "routeId='" + routeId + '\'' + ", routeName='" + routeName + '\'' + ", stops=" + stops + '}';
    }

    public String getStopNameResult() {
        StringBuilder tempStopName = new StringBuilder();
        for (Stop stop : stops) {
            tempStopName.append(stop.getName()).append("-");
        }

        return new String(tempStopName);
    }
}

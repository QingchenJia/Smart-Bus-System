package SmartBusSystem.service.TableRow;

import SmartBusSystem.pojo.Stop;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
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

    @Override
    public String toString() {
        return "RouteGuideRow{" + "routeId='" + routeId + '\'' + ", routeName='" + routeName + '\'' + ", stops=" + stops + '}';
    }

    public String getStopNameResult() {
        StringBuilder tempStopName = new StringBuilder();
        for (Stop stop : stops) {
            tempStopName.append(stop.getName()).append("-");
        }

        String stringStopName = new String(tempStopName);
        return stringStopName.substring(0, stringStopName.length() - 1);
    }
}

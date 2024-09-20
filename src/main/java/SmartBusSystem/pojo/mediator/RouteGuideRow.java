package SmartBusSystem.pojo.mediator;

import SmartBusSystem.pojo.Stop;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RouteGuideRow {
    private String routeId;
    private String routeName;
    private List<Stop> stops;

    public String getStopNameResult() {
        StringBuilder tempStopName = new StringBuilder();
        for (Stop stop : stops) {
            tempStopName.append(stop.getName()).append("-");
        }

        String stringStopName = new String(tempStopName);
        return stringStopName.substring(0, stringStopName.length() - 1);
    }
}

package SmartBusSystem.pojo.mediator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RouteStopLink {
    private String routeId;
    private String currentStopId;
    private String nextStopId;
    private int sequence;
}

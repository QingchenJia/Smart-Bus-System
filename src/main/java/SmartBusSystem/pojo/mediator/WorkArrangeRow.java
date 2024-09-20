package SmartBusSystem.pojo.mediator;

import SmartBusSystem.pojo.Bus;
import SmartBusSystem.pojo.Driver;
import SmartBusSystem.pojo.Route;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkArrangeRow {
    private String dayOfWeek;
    private Bus bus;
    private Route route;
    private Driver driver;
}

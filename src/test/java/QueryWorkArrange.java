import SmartBusSystem.service.TableRow.WorkArrangeRow;
import SmartBusSystem.service.function.DriverHomePage;

import java.util.List;

public class QueryWorkArrange {
    public static void main(String[] args) {
        List<WorkArrangeRow> ownWorkArrangeRow = DriverHomePage.getOwnWorkArrangeRow("D10001");
        ownWorkArrangeRow.forEach(System.out::println);
    }
}

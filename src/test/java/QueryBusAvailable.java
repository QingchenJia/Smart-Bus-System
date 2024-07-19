import SmartBusSystem.pojo.Bus;
import SmartBusSystem.service.function.AdminEditSchedule;

import java.util.List;

public class QueryBusAvailable {
    public static void main(String[] args) {
        List<Bus> buses = AdminEditSchedule.queryBusAvailable("星期7");
        buses.forEach(System.out::println);
    }
}

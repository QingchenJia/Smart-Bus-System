package SmartBusSystem.service.function;

import SmartBusSystem.mapper.DriverMapper;
import SmartBusSystem.mapper.ScheduleMapper;
import SmartBusSystem.pojo.Bus;
import SmartBusSystem.pojo.Driver;
import SmartBusSystem.pojo.Route;
import SmartBusSystem.pojo.Schedule;
import SmartBusSystem.service.DatabaseOperation;
import SmartBusSystem.service.TableRow.WorkArrangeRow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdminHomePage {
    public static List<String> dayOfWeek = new ArrayList<>();

    static {
        Collections.addAll(dayOfWeek, "星期1", "星期2", "星期3", "星期4", "星期5", "星期6", "星期7");
    }

    public static List<WorkArrangeRow> getAllWorkArrange() {
        List<WorkArrangeRow> allWorkArrange = new ArrayList<>();

        ScheduleMapper scheduleMapper = DatabaseOperation.session.getMapper(ScheduleMapper.class);
        for (String day : dayOfWeek) {
            List<Schedule> schedules = scheduleMapper.SelectByDayOfWeek(day);

            for (Schedule schedule : schedules) {
                String licenseNum = schedule.getLicenseNumber();
                Bus bus = DriverHomePage.queryBusById(licenseNum);

                String routeId = bus.getRID();
                Route route = DriverHomePage.queryRouteById(routeId);

                String DID = schedule.getDID();
                Driver driver = DriverHomePage.queryCurrentDriverInformation(DID);

                allWorkArrange.add(new WorkArrangeRow(day, bus, route, driver));
            }
        }

        return allWorkArrange;
    }
}

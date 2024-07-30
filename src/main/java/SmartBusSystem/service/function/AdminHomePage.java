package SmartBusSystem.service.function;

import SmartBusSystem.mapper.ScheduleMapper;
import SmartBusSystem.pojo.Bus;
import SmartBusSystem.pojo.Driver;
import SmartBusSystem.pojo.Route;
import SmartBusSystem.pojo.Schedule;
import SmartBusSystem.service.tool.DatabaseOperation;
import SmartBusSystem.service.TableRow.WorkArrangeRow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdminHomePage {
    public static List<String> dayOfWeek = new ArrayList<>();
    private static final ScheduleMapper scheduleMapper;

    static {
        Collections.addAll(dayOfWeek, "星期1", "星期2", "星期3", "星期4", "星期5", "星期6", "星期7");
        scheduleMapper = DatabaseOperation.session.getMapper(ScheduleMapper.class);
    }

    public static List<WorkArrangeRow> getAllWorkArrange() {
        List<WorkArrangeRow> allWorkArrange = new ArrayList<>();

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

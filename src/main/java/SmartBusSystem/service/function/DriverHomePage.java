package SmartBusSystem.service.function;

import SmartBusSystem.mapper.BusMapper;
import SmartBusSystem.mapper.DriverMapper;
import SmartBusSystem.mapper.RouteMapper;
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

public class DriverHomePage {
    public static Driver queryCurrentDriverInformation(String DID) {
        DriverMapper driverMapper = DatabaseOperation.session.getMapper(DriverMapper.class);
        Driver driver = driverMapper.SelectById(DID);
        System.out.println("当前司机->" + driver);
        return driver;
    }

    public static Bus queryBusByRouteId(String routeId) {
        BusMapper busMapper = DatabaseOperation.session.getMapper(BusMapper.class);
        Bus bus = busMapper.SelectByLicenseNumber(routeId);
        System.out.println("检索车辆->" + bus);
        return bus;
    }

    public static Route queryRouteById(String routeId) {
        return UserSearchRoute.getRouteById(routeId);
    }

    public static List<WorkArrangeRow> getOwnWorkArrangeRow(String currentId) {
        ScheduleMapper scheduleMapper = DatabaseOperation.session.getMapper(ScheduleMapper.class);
        List<Schedule> schedules = scheduleMapper.SelectByDriverID(currentId);
        System.out.println("工作安排->" + schedules);

        List<WorkArrangeRow> workArrangeRows = new ArrayList<>();

        for (Schedule schedule : schedules) {
            String licenseNumber = schedule.getLicenseNumber();
            Bus bus = queryBusByRouteId(licenseNumber);

            String routeId = bus.getRID();
            Route route = queryRouteById(routeId);

            String dayOfWeek = schedule.getTime();
            workArrangeRows.add(new WorkArrangeRow(dayOfWeek, bus, route));
        }

        return workArrangeRows;
    }
}

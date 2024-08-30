package SmartBusSystem.service.homepage;

import SmartBusSystem.dao.BusDao;
import SmartBusSystem.dao.DriverDao;
import SmartBusSystem.dao.ScheduleDao;
import SmartBusSystem.dao.impl.BusDaoImpl;
import SmartBusSystem.dao.impl.DriverDaoImpl;
import SmartBusSystem.dao.impl.ScheduleDaoImpl;
import SmartBusSystem.pojo.Bus;
import SmartBusSystem.pojo.Driver;
import SmartBusSystem.pojo.Route;
import SmartBusSystem.pojo.Schedule;
import SmartBusSystem.service.TableRow.WorkArrangeRow;
import SmartBusSystem.service.query.RouteQuery;

import java.util.ArrayList;
import java.util.List;

public class DriverHomePage {
    private static final BusDao busDao = new BusDaoImpl();
    private static final DriverDao driverDao = new DriverDaoImpl();
    private static final ScheduleDao scheduleDao = new ScheduleDaoImpl();

    public static Driver queryCurrentDriverInformation(String DID) {
        return driverDao.SelectById(DID);
    }

    public static Bus queryBusById(String licenseNum) {
        return busDao.SelectByLicenseNumber(licenseNum);
    }

    public static Route queryRouteById(String routeId) {
        return RouteQuery.getRouteById(routeId);
    }

    public static List<WorkArrangeRow> getOwnWorkArrangeRow(String currentId) {
        List<Schedule> schedules = scheduleDao.SelectByDriverID(currentId);

        List<WorkArrangeRow> workArrangeRows = new ArrayList<>();

        for (Schedule schedule : schedules) {
            String licenseNumber = schedule.getLicenseNumber();
            Bus bus = queryBusById(licenseNumber);

            String routeId = bus.getRID();
            Route route = queryRouteById(routeId);

            Driver driver = queryCurrentDriverInformation(currentId);

            String dayOfWeek = schedule.getTime();
            workArrangeRows.add(new WorkArrangeRow(dayOfWeek, bus, route, driver));
        }

        return workArrangeRows;
    }
}

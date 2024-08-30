package SmartBusSystem.service.homepage;

import SmartBusSystem.dao.BusDao;
import SmartBusSystem.dao.DriverDao;
import SmartBusSystem.dao.RouteDao;
import SmartBusSystem.dao.ScheduleDao;
import SmartBusSystem.dao.impl.BusDaoImpl;
import SmartBusSystem.dao.impl.DriverDaoImpl;
import SmartBusSystem.dao.impl.RouteDaoImpl;
import SmartBusSystem.dao.impl.ScheduleDaoImpl;
import SmartBusSystem.pojo.Bus;
import SmartBusSystem.pojo.Driver;
import SmartBusSystem.pojo.Route;
import SmartBusSystem.pojo.Schedule;
import SmartBusSystem.pojo.mediator.WorkArrangeRow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdminHomePage {
    private static final ScheduleDao scheduleDao = new ScheduleDaoImpl();
    private static final RouteDao routeDao = new RouteDaoImpl();
    private static final BusDao busDao = new BusDaoImpl();
    private static final DriverDao driverDao = new DriverDaoImpl();
    public static List<String> dayOfWeek = new ArrayList<>();

    static {
        Collections.addAll(dayOfWeek, "星期1", "星期2", "星期3", "星期4", "星期5", "星期6", "星期7");
    }

    public List<WorkArrangeRow> getAllWorkArrange() {
        List<WorkArrangeRow> allWorkArrange = new ArrayList<>();

        for (String day : dayOfWeek) {
            List<Schedule> schedules = scheduleDao.SelectByDayOfWeek(day);

            for (Schedule schedule : schedules) {
                String licenseNum = schedule.getLicenseNumber();
                Bus bus = busDao.SelectByLicenseNumber(licenseNum);

                String routeId = bus.getRID();
                Route route = routeDao.SelectById(routeId);

                String DID = schedule.getDID();
                Driver driver = driverDao.SelectById(DID);

                allWorkArrange.add(new WorkArrangeRow(day, bus, route, driver));
            }
        }

        return allWorkArrange;
    }
}

package SmartBusSystem.service.function;

import SmartBusSystem.mapper.BusMapper;
import SmartBusSystem.mapper.DriverMapper;
import SmartBusSystem.mapper.ScheduleMapper;
import SmartBusSystem.pojo.Bus;
import SmartBusSystem.pojo.Driver;
import SmartBusSystem.pojo.Route;
import SmartBusSystem.pojo.Schedule;
import SmartBusSystem.service.TableRow.WorkArrangeRow;
import SmartBusSystem.service.tool.DatabaseOperation;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

public class DriverHomePage {
    private static final SqlSession sqlSession;
    private static final BusMapper busMapper;
    private static final DriverMapper driverMapper;
    private static final ScheduleMapper scheduleMapper;

    static {
        sqlSession = DatabaseOperation.getSqlSession();
        busMapper = sqlSession.getMapper(BusMapper.class);
        driverMapper = sqlSession.getMapper(DriverMapper.class);
        scheduleMapper = sqlSession.getMapper(ScheduleMapper.class);
    }

    public static Driver queryCurrentDriverInformation(String DID) {
        Driver driver = driverMapper.SelectById(DID);
        System.out.println("当前司机->" + driver);
        return driver;
    }

    public static Bus queryBusById(String licenseNum) {
        Bus bus = busMapper.SelectByLicenseNumber(licenseNum);
        System.out.println("检索车辆->" + bus);
        return bus;
    }

    public static Route queryRouteById(String routeId) {
        return UserSearchRoute.getRouteById(routeId);
    }

    public static List<WorkArrangeRow> getOwnWorkArrangeRow(String currentId) {
        List<Schedule> schedules = scheduleMapper.SelectByDriverID(currentId);
        System.out.println("工作安排->" + schedules);

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

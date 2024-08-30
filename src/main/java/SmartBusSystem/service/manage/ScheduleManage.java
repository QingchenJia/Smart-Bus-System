package SmartBusSystem.service.manage;

import SmartBusSystem.dao.BusDao;
import SmartBusSystem.dao.DriverDao;
import SmartBusSystem.dao.ScheduleDao;
import SmartBusSystem.dao.impl.BusDaoImpl;
import SmartBusSystem.dao.impl.DriverDaoImpl;
import SmartBusSystem.dao.impl.ScheduleDaoImpl;
import SmartBusSystem.pojo.Bus;
import SmartBusSystem.pojo.Driver;
import SmartBusSystem.pojo.Schedule;

import java.util.List;

public class ScheduleManage {
    private static final BusDao busDao = new BusDaoImpl();
    private static final DriverDao driverDao = new DriverDaoImpl();
    private static final ScheduleDao scheduleDao = new ScheduleDaoImpl();

    public static List<Bus> queryBusAvailable(String dayOfWeek) {   // 可安排的车辆 状态正常且当天无人使用
        return busDao.SelectBusAvailable(dayOfWeek);
    }

    public static List<String> listBus2listBusLicenseNumber(List<Bus> buses) {
        return BusManage.listBus2listBusLicenseNumber(buses);
    }

    public static List<Driver> queryDriverIsArrangedOnTheDay(String time) {
        return driverDao.SelectDriverIsArranged(time);
    }

    public static List<String> listDriver2listDriverId(List<Driver> drivers) {
        return drivers.stream().map(Driver::getID).toList();
    }

    public static Schedule queryScheduleById(Schedule schedule) {
        return scheduleDao.SelectById(schedule);
    }

    public static void deleteScheduleById(String DID, String dayOfWeek) {
        scheduleDao.DeleteSchedule(DID, dayOfWeek);
    }

    public static void addNewSchedule(Schedule schedule) {
        scheduleDao.InsertSchedule(schedule);
    }

    public static void updateSchedule(Schedule schedule) {
        scheduleDao.UpdateSchedule(schedule);
    }

    public static List<Driver> queryDriverAvailable(String time) {
        return driverDao.SelectDriverAvailable(time);
    }
}

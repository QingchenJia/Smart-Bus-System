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

    public List<Bus> queryBusAvailable(String dayOfWeek) {   // 可安排的车辆 状态正常且当天无人使用
        return busDao.SelectBusAvailable(dayOfWeek);
    }

    public List<String> listBus2listBusLicenseNumber(List<Bus> buses) {
        return buses.stream()
                .map(Bus::getLicenseNumber)
                .toList();
    }

    public List<String> getAvailableBusLicenseNum(String dayOfWeek) {
        return listBus2listBusLicenseNumber(queryBusAvailable(dayOfWeek));
    }

    public List<Driver> queryDriverIsArrangedOnTheDay(String time) {
        return driverDao.SelectDriverIsArranged(time);
    }

    public List<Driver> queryDriverAvailable(String time) {
        return driverDao.SelectDriverAvailable(time);
    }

    public List<String> listDriver2listDriverId(List<Driver> drivers) {
        return drivers.stream()
                .map(Driver::getID)
                .toList();
    }

    public List<String> getArrangedOnTheDayDriverId(String time) {
        return listDriver2listDriverId(queryDriverIsArrangedOnTheDay(time));
    }

    public List<String> getAvailableDriverId(String time) {
        return listDriver2listDriverId(queryDriverAvailable(time));
    }

    public Schedule queryScheduleById(Schedule schedule) {
        return scheduleDao.SelectById(schedule);
    }

    public void deleteScheduleById(String DID, String dayOfWeek) {
        scheduleDao.DeleteSchedule(DID, dayOfWeek);
    }

    public void addNewSchedule(Schedule schedule) {
        scheduleDao.InsertSchedule(schedule);
    }

    public void updateSchedule(Schedule schedule) {
        scheduleDao.UpdateSchedule(schedule);
    }
}

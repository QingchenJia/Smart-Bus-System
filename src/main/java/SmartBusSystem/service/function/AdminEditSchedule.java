package SmartBusSystem.service.function;

import SmartBusSystem.mapper.BusMapper;
import SmartBusSystem.mapper.DriverMapper;
import SmartBusSystem.mapper.ScheduleMapper;
import SmartBusSystem.pojo.Bus;
import SmartBusSystem.pojo.Driver;
import SmartBusSystem.pojo.Schedule;
import SmartBusSystem.service.DatabaseOperation;

import java.util.List;

public class AdminEditSchedule {
    private static final BusMapper busMapper;
    private static final DriverMapper driverMapper;
    private static final ScheduleMapper scheduleMapper;

    static {
        busMapper = DatabaseOperation.session.getMapper(BusMapper.class);
        driverMapper = DatabaseOperation.session.getMapper(DriverMapper.class);
        scheduleMapper = DatabaseOperation.session.getMapper(ScheduleMapper.class);
    }

    public static List<Bus> queryBusAvailable(String dayOfWeek) {   // 可安排的车辆 状态正常且当天无人使用
        List<Bus> buses = busMapper.SelectBusAvailable(dayOfWeek);
        System.out.println("可用车辆->" + buses);
        return buses;
    }

    public static List<String> listBus2listBusLicenseNumber(List<Bus> buses) {
        return AdminEditBus.listBus2listBusLicenseNumber(buses);
    }

    public static List<Driver> queryAllDriver() {
        List<Driver> drivers = driverMapper.SelectAll();
        System.out.println("全部司机->" + drivers);
        return drivers;
    }

    public static List<Driver> queryDriverIsArrangedOnTheDay(String time) {
        List<Driver> drivers = driverMapper.SelectDriverIsArranged(time);
        System.out.println("在班司机->" + drivers);
        return drivers;
    }

    public static List<String> listDriver2listDriverId(List<Driver> drivers) {
        return drivers.stream().map(Driver::getID).toList();
    }

    public static Schedule queryScheduleById(Schedule schedule) {
        Schedule scheduleResult = scheduleMapper.SelectById(schedule);
        System.out.println("查询排班->" + scheduleResult);
        return scheduleResult;
    }

    public static void deleteScheduleById(String DID, String dayOfWeek) {
        scheduleMapper.DeleteSchedule(DID, dayOfWeek);
        DatabaseOperation.session.commit();
    }

    public static void addNewSchedule(Schedule schedule) {
        scheduleMapper.InsertSchedule(schedule);
        DatabaseOperation.session.commit();
    }

    public static void updateSchedule(Schedule schedule) {
        scheduleMapper.UpdateSchedule(schedule);
        DatabaseOperation.session.commit();
    }

    public static List<Driver> queryDriverAvailable(String time) {
        List<Driver> drivers = driverMapper.SelectDriverAvailable(time);
        System.out.println("可用司机->" + drivers);
        return drivers;
    }
}

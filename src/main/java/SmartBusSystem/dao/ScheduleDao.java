package SmartBusSystem.dao;

import SmartBusSystem.pojo.Schedule;

import java.util.List;

public interface ScheduleDao {
    Schedule SelectById(Schedule schedule);

    void InsertSchedule(Schedule schedule);

    List<Schedule> SelectByDriverID(String DID);

    List<Schedule> SelectByDayOfWeek(String dayOfWeek);

    void UpdateSchedule(Schedule schedule);

    void DeleteSchedule(String DID, String dayOfWeek);
}

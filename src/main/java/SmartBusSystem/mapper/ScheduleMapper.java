package SmartBusSystem.mapper;

import SmartBusSystem.pojo.Schedule;

import java.util.List;

public interface ScheduleMapper {
    List<Schedule> SelectById(Schedule schedule);
    void InsertSchedule(Schedule schedule);
}

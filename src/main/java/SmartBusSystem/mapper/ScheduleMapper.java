package SmartBusSystem.mapper;

import SmartBusSystem.pojo.Schedule;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ScheduleMapper {
    Schedule SelectById(Schedule schedule);

    void InsertSchedule(Schedule schedule);

    List<Schedule> SelectByDriverID(@Param("DID") String DID);

    List<Schedule> SelectByDayOfWeek(@Param("dayOfWeek") String dayOfWeek);

    void UpdateSchedule(Schedule schedule);

    void DeleteSchedule(@Param("DID") String DID, @Param("dayOfWeek") String dayOfWeek);
}

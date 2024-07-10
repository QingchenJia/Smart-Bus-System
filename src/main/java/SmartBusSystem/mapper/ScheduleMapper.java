package SmartBusSystem.mapper;

import SmartBusSystem.pojo.Schedule;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ScheduleMapper {
    List<Schedule> SelectById(Schedule schedule);

    void InsertSchedule(Schedule schedule);

    List<Schedule> SelectByDriverID(@Param("DID") String DID);
}

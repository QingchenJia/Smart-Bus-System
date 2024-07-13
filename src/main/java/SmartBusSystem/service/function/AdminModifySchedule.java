package SmartBusSystem.service.function;

import SmartBusSystem.mapper.ScheduleMapper;
import SmartBusSystem.pojo.Schedule;
import SmartBusSystem.service.DatabaseOperation;

public class AdminModifySchedule {
    public static void addNewSchedule(Schedule schedule) {
        ScheduleMapper scheduleMapper = DatabaseOperation.session.getMapper(ScheduleMapper.class);
        scheduleMapper.InsertSchedule(schedule);
        DatabaseOperation.session.commit();
    }

    public static void updateSchedule(Schedule schedule) {
        ScheduleMapper scheduleMapper = DatabaseOperation.session.getMapper(ScheduleMapper.class);
        scheduleMapper.UpdateSchedule(schedule);
        DatabaseOperation.session.commit();
    }

    public static void deleteSchedule(String DID, String time) {
        ScheduleMapper scheduleMapper = DatabaseOperation.session.getMapper(ScheduleMapper.class);
        scheduleMapper.DeleteSchedule(DID, time);
        DatabaseOperation.session.commit();
    }
}

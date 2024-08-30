package SmartBusSystem.dao.impl;

import SmartBusSystem.dao.ScheduleDao;
import SmartBusSystem.mapper.ScheduleMapper;
import SmartBusSystem.pojo.Schedule;
import SmartBusSystem.Util.DatabaseOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

@Slf4j
public class ScheduleDaoImpl implements ScheduleDao {
    private static final SqlSession sqlSession;
    private static final ScheduleMapper scheduleMapper;

    static {
        sqlSession = DatabaseOperation.getSqlSession();
        scheduleMapper = sqlSession.getMapper(ScheduleMapper.class);
    }

    @Override
    public Schedule SelectById(Schedule schedule) {
        Schedule scheduleResult = scheduleMapper.SelectById(schedule);
        log.info("查询排班->" + scheduleResult);
        return scheduleResult;
    }

    @Override
    public void InsertSchedule(Schedule schedule) {
        scheduleMapper.InsertSchedule(schedule);
        sqlSession.commit();
    }

    @Override
    public List<Schedule> SelectByDriverID(String DID) {
        List<Schedule> schedules = scheduleMapper.SelectByDriverID(DID);
        log.info("工作安排->" + schedules);
        return schedules;
    }

    @Override
    public List<Schedule> SelectByDayOfWeek(String dayOfWeek) {
        List<Schedule> schedules = scheduleMapper.SelectByDayOfWeek(dayOfWeek);
        log.info("工作安排->" + schedules);
        return schedules;
    }

    @Override
    public void UpdateSchedule(Schedule schedule) {
        scheduleMapper.UpdateSchedule(schedule);
        sqlSession.commit();
    }

    @Override
    public void DeleteSchedule(String DID, String dayOfWeek) {
        scheduleMapper.DeleteSchedule(DID, dayOfWeek);
        sqlSession.commit();
    }
}

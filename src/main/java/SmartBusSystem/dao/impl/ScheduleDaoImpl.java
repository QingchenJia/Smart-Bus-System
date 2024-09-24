package SmartBusSystem.dao.impl;

import SmartBusSystem.dao.ScheduleDao;
import SmartBusSystem.mapper.ScheduleMapper;
import SmartBusSystem.pojo.Schedule;
import SmartBusSystem.Util.DatabaseUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ScheduleDaoImpl implements ScheduleDao {
    private static final SqlSession sqlSession;
    private static final ScheduleMapper scheduleMapper;

    static {
        sqlSession = DatabaseUtil.getSqlSession();
        scheduleMapper = sqlSession.getMapper(ScheduleMapper.class);
    }

    @Override
    public Schedule SelectById(Schedule schedule) {
        return scheduleMapper.SelectById(schedule);
    }

    @Override
    public void InsertSchedule(Schedule schedule) {
        scheduleMapper.InsertSchedule(schedule);
        sqlSession.commit();
    }

    @Override
    public List<Schedule> SelectByDriverID(String DID) {
        return scheduleMapper.SelectByDriverID(DID);
    }

    @Override
    public List<Schedule> SelectByDayOfWeek(String dayOfWeek) {
        return scheduleMapper.SelectByDayOfWeek(dayOfWeek);
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

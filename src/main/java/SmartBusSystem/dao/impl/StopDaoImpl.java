package SmartBusSystem.dao.impl;

import SmartBusSystem.dao.StopDao;
import SmartBusSystem.mapper.StopMapper;
import SmartBusSystem.pojo.Stop;
import SmartBusSystem.Util.DatabaseUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StopDaoImpl implements StopDao {
    private static final SqlSession sqlSession;
    private static final StopMapper stopMapper;

    static {
        sqlSession = DatabaseUtil.getSqlSession();
        stopMapper = sqlSession.getMapper(StopMapper.class);
    }

    @Override
    public List<Stop> SelectAll() {
        return stopMapper.SelectAll();
    }

    @Override
    public Stop SelectById(String ID) {
        return stopMapper.SelectById(ID);
    }

    @Override
    public void InsertStop(Stop stop) {
        stopMapper.InsertStop(stop);
        sqlSession.commit();
    }

    @Override
    public List<Stop> SelectStopOrderInRoute(String RID) {
        return stopMapper.SelectStopOrderInRoute(RID);
    }

    @Override
    public List<Stop> SelectStopBySimilarName(String similarName) {
        return stopMapper.SelectStopBySimilarName(similarName);
    }

    @Override
    public Stop SelectByName(String name) {
        return stopMapper.SelectByName(name);
    }
}

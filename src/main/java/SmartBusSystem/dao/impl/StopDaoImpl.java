package SmartBusSystem.dao.impl;

import SmartBusSystem.dao.StopDao;
import SmartBusSystem.mapper.StopMapper;
import SmartBusSystem.pojo.Stop;
import SmartBusSystem.service.tool.DatabaseOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

@Slf4j
public class StopDaoImpl implements StopDao {
    private static final SqlSession sqlSession;
    private static final StopMapper stopMapper;

    static {
        sqlSession = DatabaseOperation.getSqlSession();
        stopMapper = sqlSession.getMapper(StopMapper.class);
    }

    @Override
    public List<Stop> SelectAll() {
        List<Stop> stops = stopMapper.SelectAll();
        log.info("全部站点->" + stops);
        return stops;
    }

    @Override
    public Stop SelectById(String ID) {
        Stop stop = stopMapper.SelectById(ID);
        log.info("唯一站点->" + stop);
        return stop;
    }

    @Override
    public void InsertStop(Stop stop) {
        stopMapper.InsertStop(stop);
        sqlSession.commit();
    }

    @Override
    public List<Stop> SelectStopOrderInRoute(String RID) {
        List<Stop> stops = stopMapper.SelectStopOrderInRoute(RID);
        log.info("经行站点->" + stops);  // 控制台展示查询结果
        return stops;
    }

    @Override
    public List<Stop> SelectStopBySimilarName(String similarName) {
        List<Stop> stops = stopMapper.SelectStopBySimilarName(similarName);
        log.info("模糊匹配->" + stops);
        return stops;
    }

    @Override
    public Stop SelectByName(String name) {
        Stop stop = stopMapper.SelectByName(name);
        log.info("查询站点->" + stop);
        return stop;
    }
}

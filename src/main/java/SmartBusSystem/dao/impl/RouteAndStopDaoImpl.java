package SmartBusSystem.dao.impl;

import SmartBusSystem.dao.RouteAndStopDao;
import SmartBusSystem.mapper.RouteAndStopMapper;
import SmartBusSystem.pojo.RouteAndStop;
import SmartBusSystem.Util.DatabaseUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class RouteAndStopDaoImpl implements RouteAndStopDao {
    private static final SqlSession sqlSession;
    private static final RouteAndStopMapper routeAndStopMapper;

    static {
        sqlSession = DatabaseUtil.getSqlSession();
        routeAndStopMapper = sqlSession.getMapper(RouteAndStopMapper.class);
    }

    @Override
    public List<RouteAndStop> SelectById(RouteAndStop routeAndStop) {
        return routeAndStopMapper.SelectById(routeAndStop);
    }

    @Override
    public void InsertRouteAndStop(RouteAndStop routeAndStop) {
        routeAndStopMapper.InsertRouteAndStop(routeAndStop);
        sqlSession.commit();
    }
}

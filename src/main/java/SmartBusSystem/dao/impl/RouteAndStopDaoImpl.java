package SmartBusSystem.dao.impl;

import SmartBusSystem.dao.RouteAndStopDao;
import SmartBusSystem.mapper.RouteAndStopMapper;
import SmartBusSystem.pojo.RouteAndStop;
import SmartBusSystem.service.tool.DatabaseOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

@Slf4j
public class RouteAndStopDaoImpl implements RouteAndStopDao {
    private static final SqlSession sqlSession;
    private static final RouteAndStopMapper routeAndStopMapper;

    static {
        sqlSession = DatabaseOperation.getSqlSession();
        routeAndStopMapper = sqlSession.getMapper(RouteAndStopMapper.class);
    }

    @Override
    public List<RouteAndStop> SelectById(RouteAndStop routeAndStop) {
        List<RouteAndStop> routeAndStops = routeAndStopMapper.SelectById(routeAndStop);
        log.info("路站关系->" + routeAndStops);
        return routeAndStops;
    }

    @Override
    public void InsertRouteAndStop(RouteAndStop routeAndStop) {
        routeAndStopMapper.InsertRouteAndStop(routeAndStop);
        sqlSession.commit();
    }
}

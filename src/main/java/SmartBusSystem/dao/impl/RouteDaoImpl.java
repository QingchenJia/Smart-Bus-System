package SmartBusSystem.dao.impl;

import SmartBusSystem.dao.RouteDao;
import SmartBusSystem.mapper.RouteMapper;
import SmartBusSystem.pojo.Route;
import SmartBusSystem.Util.DatabaseUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class RouteDaoImpl implements RouteDao {
    private static final SqlSession sqlSession;
    private static final RouteMapper routeMapper;

    static {
        sqlSession = DatabaseUtil.getSqlSession();
        routeMapper = sqlSession.getMapper(RouteMapper.class);
    }

    @Override
    public List<Route> SelectAll() {
        return routeMapper.SelectAll();
    }

    @Override
    public Route SelectById(String ID) {
        return routeMapper.SelectById(ID);
    }

    @Override
    public void InsertRoute(Route route) {
        routeMapper.InsertRoute(route);
        sqlSession.commit();
    }

    @Override
    public List<Route> SelectRoutePassByStop(String stopName) {
        return routeMapper.SelectRoutePassByStop(stopName);
    }

    @Override
    public List<Route> SelectStatusIsOne() {
        return routeMapper.SelectStatusIsOne();
    }
}

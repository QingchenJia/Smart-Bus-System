package SmartBusSystem.dao.impl;

import SmartBusSystem.dao.RouteDao;
import SmartBusSystem.mapper.RouteMapper;
import SmartBusSystem.pojo.Route;
import SmartBusSystem.Util.DatabaseUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

@Slf4j
public class RouteDaoImpl implements RouteDao {
    private static final SqlSession sqlSession;
    private static final RouteMapper routeMapper;

    static {
        sqlSession = DatabaseUtil.getSqlSession();
        routeMapper = sqlSession.getMapper(RouteMapper.class);
    }

    @Override
    public List<Route> SelectAll() {
        List<Route> routes = routeMapper.SelectAll();
        log.info("所有线路->" + routes); // 控制台展示查询结果
        return routes;
    }

    @Override
    public Route SelectById(String ID) {
        Route route = routeMapper.SelectById(ID);
        log.info("查询线路->" + route);
        return route;
    }

    @Override
    public void InsertRoute(Route route) {
        routeMapper.InsertRoute(route);
        sqlSession.commit();
    }

    @Override
    public List<Route> SelectRoutePassByStop(String stopName) {
        List<Route> routes = routeMapper.SelectRoutePassByStop(stopName);
        log.info("经行路线->" + routes);
        return routes;
    }

    @Override
    public List<Route> SelectStatusIsOne() {
        List<Route> routes = routeMapper.SelectStatusIsOne();
        log.info("正常路线->" + routes);
        return routes;
    }
}

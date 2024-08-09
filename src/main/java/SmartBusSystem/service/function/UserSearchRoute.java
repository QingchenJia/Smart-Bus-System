package SmartBusSystem.service.function;

import SmartBusSystem.mapper.RouteMapper;
import SmartBusSystem.mapper.StopMapper;
import SmartBusSystem.pojo.Route;
import SmartBusSystem.pojo.Stop;
import SmartBusSystem.service.tool.DatabaseOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

@Slf4j
public class UserSearchRoute {
    private static final SqlSession sqlSession;
    private static final StopMapper stopMapper;
    private static final RouteMapper routeMapper;

    static {
        sqlSession = DatabaseOperation.getSqlSession();
        stopMapper = sqlSession.getMapper(StopMapper.class);
        routeMapper = sqlSession.getMapper(RouteMapper.class);
    }

    public static List<Route> showAllRoute() {
        List<Route> routes = routeMapper.SelectAll();
        log.info("全部线路->" + routes);
        return routes;
    }

    public static List<String> listRoute2listRouteId(List<Route> routes) {
        return routes.stream().map(route -> route.getID() + "路").toList();
    }

    public static Route getRouteById(String ID) {
        Route route = routeMapper.SelectById(ID);
        log.info("查询线路->" + route);
        return route;
    }

    public static List<Stop> searchPassByStop(String RID) {
        List<Stop> stops = stopMapper.SelectStopOrderInRoute(RID);
        log.info("途径站点->" + stops);
        return stops;
    }

    public static List<String> listStop2listStopName(List<Stop> stops) {
        return stops.stream().map(Stop::getName).toList();
    }
}

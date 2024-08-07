package SmartBusSystem.service.function;

import SmartBusSystem.mapper.RouteMapper;
import SmartBusSystem.mapper.StopMapper;
import SmartBusSystem.pojo.Route;
import SmartBusSystem.pojo.Stop;
import SmartBusSystem.service.tool.DatabaseOperation;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserSearchStop {
    private static final SqlSession sqlSession;
    private static final StopMapper stopMapper;
    private static final RouteMapper routeMapper;

    static {
        sqlSession = DatabaseOperation.getSqlSession();
        stopMapper = sqlSession.getMapper(StopMapper.class);
        routeMapper = sqlSession.getMapper(RouteMapper.class);
    }

    public static List<Stop> searchBySimilarName(String similarName) {
        List<Stop> stops = stopMapper.SelectStopBySimilarName(similarName);
        System.out.println("模糊匹配->" + stops);
        return stops;
    }

    public static List<String> listStop2listStopName(List<Stop> stops) {
        return stops.stream().map(Stop::getName).toList();
    }

    public static List<Stop> showAllStop() {
        List<Stop> stops = stopMapper.SelectAll();
        System.out.println("全部站点->" + stops);
        return stops;
    }

    public static List<Route> searchPassByRoute(String stopName) {
        List<Route> routes = routeMapper.SelectRoutePassByStop(stopName);
        System.out.println("经行路线->" + routes);
        return routes;
    }

    public static List<String> listRoute2listRouteBasicInformation(List<Route> routes) {
        return routes.stream().map(route -> route.getID() + "路 " + route.getStartTime() + "->" + route.getEndTime()).toList();
    }

    public static List<String> listRoute2listRouteId(List<Route> routes) {
        return routes.stream().map(Route::getID).toList();
    }

    public static Stop getStopByName(String name) {
        Stop stop = stopMapper.SelectByName(name);
        System.out.println("查询站点->" + stop);
        return stop;
    }
}

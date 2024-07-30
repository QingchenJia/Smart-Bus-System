package SmartBusSystem.service.function;

import SmartBusSystem.mapper.RouteMapper;
import SmartBusSystem.mapper.StopMapper;
import SmartBusSystem.pojo.Route;
import SmartBusSystem.pojo.Stop;
import SmartBusSystem.service.tool.DatabaseOperation;

import java.util.List;

public class UserSearchRoute {
    private static final StopMapper stopMapper;
    private static final RouteMapper routeMapper;

    static {
        stopMapper = DatabaseOperation.session.getMapper(StopMapper.class);
        routeMapper = DatabaseOperation.session.getMapper(RouteMapper.class);
    }
    public static List<Route> showAllRoute() {
        List<Route> routes = routeMapper.SelectAll();
        System.out.println("全部线路->" + routes);
        return routes;
    }

    public static List<String> listRoute2listRouteId(List<Route> routes) {
        return routes.stream().map(route -> route.getID() + "路").toList();
    }

    public static Route getRouteById(String ID) {
        Route route = routeMapper.SelectById(ID);
        System.out.println("查询线路->" + route);
        return route;
    }

    public static List<Stop> searchPassByStop(String RID) {
        List<Stop> stops = stopMapper.SelectStopOrderInRoute(RID);
        System.out.println("途径站点->" + stops);
        return stops;
    }

    public static List<String> listStop2listStopName(List<Stop> stops) {
        return stops.stream().map(Stop::getName).toList();
    }
}

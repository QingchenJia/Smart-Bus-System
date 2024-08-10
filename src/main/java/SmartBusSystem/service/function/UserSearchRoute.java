package SmartBusSystem.service.function;

import SmartBusSystem.dao.RouteDao;
import SmartBusSystem.dao.StopDao;
import SmartBusSystem.dao.impl.RouteDaoImpl;
import SmartBusSystem.dao.impl.StopDaoImpl;
import SmartBusSystem.pojo.Route;
import SmartBusSystem.pojo.Stop;

import java.util.List;

public class UserSearchRoute {
    private static final StopDao stopDao = new StopDaoImpl();
    private static final RouteDao routeDao = new RouteDaoImpl();

    public static List<Route> showAllRoute() {
        return routeDao.SelectAll();
    }

    public static List<String> listRoute2listRouteId(List<Route> routes) {
        return routes.stream().map(route -> route.getID() + "路").toList();
    }

    public static Route getRouteById(String ID) {
        return routeDao.SelectById(ID);
    }

    public static List<Stop> searchPassByStop(String RID) {
        return stopDao.SelectStopOrderInRoute(RID);
    }

    public static List<String> listStop2listStopName(List<Stop> stops) {
        return stops.stream().map(Stop::getName).toList();
    }
}

package SmartBusSystem.service.query;

import SmartBusSystem.dao.RouteDao;
import SmartBusSystem.dao.StopDao;
import SmartBusSystem.dao.impl.RouteDaoImpl;
import SmartBusSystem.dao.impl.StopDaoImpl;
import SmartBusSystem.pojo.Route;
import SmartBusSystem.pojo.Stop;

import java.util.List;

public class RouteQuery {
    private static final StopDao stopDao = new StopDaoImpl();
    private static final RouteDao routeDao = new RouteDaoImpl();

    public List<Route> showAllRoute() {
        return routeDao.SelectAll();
    }

    public List<String> listRoute2listRouteId(List<Route> routes) {
        return routes.stream()
                .map(route -> route.getID() + "路")
                .toList();
    }

    public List<String> getAllRouteId() {
        return listRoute2listRouteId(showAllRoute());
    }

    public Route getRouteById(String ID) {
        return routeDao.SelectById(ID);
    }

    public List<Stop> searchPassByStop(String RID) {
        return stopDao.SelectStopOrderInRoute(RID);
    }

    public List<String> listStop2listStopName(List<Stop> stops) {
        return stops.stream()
                .map(Stop::getName)
                .toList();
    }

    public List<String> getPassByStopName(String RID) {
        return listStop2listStopName(searchPassByStop(RID));
    }
}

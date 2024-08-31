package SmartBusSystem.service.query;

import SmartBusSystem.dao.RouteDao;
import SmartBusSystem.dao.StopDao;
import SmartBusSystem.dao.impl.RouteDaoImpl;
import SmartBusSystem.dao.impl.StopDaoImpl;
import SmartBusSystem.pojo.Route;
import SmartBusSystem.pojo.Stop;

import java.util.List;

public class StopQuery {
    private static final StopDao stopDao = new StopDaoImpl();
    private static final RouteDao routeDao = new RouteDaoImpl();

    public List<Stop> searchBySimilarName(String similarName) {
        return stopDao.SelectStopBySimilarName(similarName);
    }

    public List<String> listStop2listStopName(List<Stop> stops) {
        return stops.stream().map(Stop::getName).toList();
    }

    public List<Stop> showAllStop() {
        return stopDao.SelectAll();
    }

    public List<String> getSimilarStopName(String similarName) {
        return listStop2listStopName(searchBySimilarName(similarName));
    }

    public List<String> getAllStopName() {
        return listStop2listStopName(showAllStop());
    }

    public List<Route> searchPassByRoute(String stopName) {
        return routeDao.SelectRoutePassByStop(stopName);
    }

    public List<String> listRoute2listRouteBasicInformation(List<Route> routes) {
        return routes.stream().map(route -> route.getID() + "路 " + route.getStartTime() + "->" + route.getEndTime()).toList();
    }

    public List<String> listRoute2listRouteId4navi(List<Route> routes) {
        return routes.stream().map(Route::getID).toList();
    }

    public Stop getStopByName(String name) {
        return stopDao.SelectByName(name);
    }
}

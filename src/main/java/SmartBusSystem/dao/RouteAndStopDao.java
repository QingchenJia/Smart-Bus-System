package SmartBusSystem.dao;

import SmartBusSystem.pojo.RouteAndStop;

import java.util.List;

public interface RouteAndStopDao {
    List<RouteAndStop> SelectById(RouteAndStop routeAndStop);
    void InsertRouteAndStop(RouteAndStop routeAndStop);
}

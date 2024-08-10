package SmartBusSystem.mapper;

import SmartBusSystem.pojo.RouteAndStop;

import java.util.List;

public interface RouteAndStopMapper {
    List<RouteAndStop> SelectById(RouteAndStop routeAndStop);

    void InsertRouteAndStop(RouteAndStop routeAndStop);
}

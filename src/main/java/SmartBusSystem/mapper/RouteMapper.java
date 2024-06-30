package SmartBusSystem.mapper;

import SmartBusSystem.pojo.Route;

import java.util.List;

public interface RouteMapper {
    List<Route> SelectAll();

    Route SelectById(String ID);

    void InsertRoute(Route route);
}

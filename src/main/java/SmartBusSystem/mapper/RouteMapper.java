package SmartBusSystem.mapper;

import SmartBusSystem.pojo.Route;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RouteMapper {
    List<Route> SelectAll();

    Route SelectById(String ID);

    void InsertRoute(Route route);

    List<Route> SelectRoutePassByStop(@Param("passByStopName") String stopName);
}

package SmartBusSystem.dao;

import SmartBusSystem.pojo.Route;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RouteDao {
    List<Route> SelectAll();

    Route SelectById(String ID);

    void InsertRoute(Route route);

    List<Route> SelectRoutePassByStop(String stopName);

    List<Route> SelectStatusIsOne();
}

package SmartBusSystem.service.homepage;

import SmartBusSystem.dao.RouteDao;
import SmartBusSystem.dao.StopDao;
import SmartBusSystem.dao.UserDao;
import SmartBusSystem.dao.impl.RouteDaoImpl;
import SmartBusSystem.dao.impl.StopDaoImpl;
import SmartBusSystem.dao.impl.UserDaoImpl;
import SmartBusSystem.pojo.Route;
import SmartBusSystem.pojo.Stop;
import SmartBusSystem.pojo.User;
import SmartBusSystem.service.TableRow.RouteGuideRow;

import java.util.ArrayList;
import java.util.List;

public class UserHomePage {
    private static final UserDao userDao = new UserDaoImpl();
    private static final StopDao stopDao = new StopDaoImpl();
    private static final RouteDao routeDao = new RouteDaoImpl();

    public static User queryCurrentUserInformation(String UID) {    // 查询当前用户信息
        return userDao.SelectById(UID);
    }

    public static List<Route> queryAllRoute() { // 查询所有线路
        return routeDao.SelectAll();
    }

    public static List<Stop> queryStopOrderInRoute(String RID) {    // 查询线路中经行站点顺序
        return stopDao.SelectStopOrderInRoute(RID);
    }

    public static List<RouteGuideRow> getAllRouteGuideRow() {   // 获取线路指南表的元组
        List<RouteGuideRow> routeGuideRows = new ArrayList<>();
        List<Route> routes = queryAllRoute();

        for (Route route : routes) {
            String routeId = route.getID();
            String routeName = route.getName();
            List<Stop> stops = queryStopOrderInRoute(routeId);

            routeGuideRows.add(new RouteGuideRow(routeId, routeName, stops));
        }

        return routeGuideRows;
    }
}

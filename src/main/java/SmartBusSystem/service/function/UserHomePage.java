package SmartBusSystem.service.function;

import SmartBusSystem.mapper.RouteMapper;
import SmartBusSystem.mapper.StopMapper;
import SmartBusSystem.mapper.UserMapper;
import SmartBusSystem.pojo.Route;
import SmartBusSystem.pojo.Stop;
import SmartBusSystem.service.TableRow.RouteGuideRow;
import SmartBusSystem.pojo.User;
import SmartBusSystem.service.tool.DatabaseOperation;

import java.util.ArrayList;
import java.util.List;

public class UserHomePage {
    private static final UserMapper userMapper;
    private static final StopMapper stopMapper;
    private static final RouteMapper routeMapper;

    static {
        userMapper = DatabaseOperation.session.getMapper(UserMapper.class);
        stopMapper = DatabaseOperation.session.getMapper(StopMapper.class);
        routeMapper = DatabaseOperation.session.getMapper(RouteMapper.class);
    }

    public static User queryCurrentUserInformation(String UID) {    // 查询当前用户信息
        User user = userMapper.SelectById(UID);
        System.out.println("当前用户->" + user);   // 控制台展示查询结果
        return user;
    }

    public static List<Route> queryAllRoute() { // 查询所有线路
        List<Route> routes = routeMapper.SelectAll();
        System.out.println("所有线路->" + routes); // 控制台展示查询结果
        return routes;
    }

    public static List<Stop> queryStopOrderInRoute(String RID) {    // 查询线路中经行站点顺序
        List<Stop> stops = stopMapper.SelectStopOrderInRoute(RID);
        System.out.println("经行站点->" + stops);  // 控制台展示查询结果
        return stops;
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

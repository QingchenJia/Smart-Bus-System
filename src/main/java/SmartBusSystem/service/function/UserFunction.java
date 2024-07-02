package SmartBusSystem.service.function;

import SmartBusSystem.mapper.RouteMapper;
import SmartBusSystem.mapper.StopMapper;
import SmartBusSystem.mapper.UserMapper;
import SmartBusSystem.pojo.Route;
import SmartBusSystem.pojo.Stop;
import SmartBusSystem.pojo.User;
import SmartBusSystem.service.DatabaseOperation;

import java.util.List;

public class UserFunction {
    public static User queryCurrentUserInformation(String UID) {    // 查询当前用户信息
        UserMapper userMapper = DatabaseOperation.session.getMapper(UserMapper.class);
        User user = userMapper.SelectById(UID);
        System.out.println(user);   // 控制台展示查询结果
        return user;
    }

    public static List<Route> queryAllRoute() {
        RouteMapper routeMapper = DatabaseOperation.session.getMapper(RouteMapper.class);
        List<Route> routes = routeMapper.SelectAll();
        System.out.println(routes); // 控制台展示查询结果
        return routes;
    }

    public static List<Stop> queryStopOrderInRoute(String RID) {
        StopMapper stopMapper = DatabaseOperation.session.getMapper(StopMapper.class);
        List<Stop> stops = stopMapper.SelectStopOrderInRoute(RID);
        System.out.println(stops);  // 控制台展示查询结果
        return stops;
    }
}

package SmartBusSystem.service.function;

import SmartBusSystem.mapper.RouteMapper;
import SmartBusSystem.mapper.StopMapper;
import SmartBusSystem.mapper.UserMapper;
import SmartBusSystem.pojo.Route;
import SmartBusSystem.pojo.Stop;
import SmartBusSystem.pojo.TableRow.RouteGuideRow;
import SmartBusSystem.pojo.User;
import SmartBusSystem.service.DatabaseOperation;
import SmartBusSystem.service.login.UserLogin;
import SmartBusSystem.service.register.UserRegister;
import com.mysql.cj.jdbc.result.UpdatableResultSet;

import java.util.ArrayList;
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

    public static List<RouteGuideRow> getAllRouteGuideRow() {
        List<RouteGuideRow> routeGuideRows = new ArrayList<>();
        List<Route> routes = queryAllRoute();

        for (Route route : routes) {
            String routeId = route.getID();
            String routeName = route.getName();
            StringBuilder tempStops = new StringBuilder();

            List<Stop> stops = queryStopOrderInRoute(routeId);

            for (Stop stop : stops) {
                tempStops.append(stop.getName()).append("-");
            }

            String stopResults = new String(tempStops);
            routeGuideRows.add(new RouteGuideRow(routeId, routeName, stopResults));
        }

        return routeGuideRows;
    }

    public static boolean checkPhoneNum(String phoneNum) {
        return UserRegister.checkPhoneNum(phoneNum);
    }

    public static void updateUserInformation(User user) {
        UserMapper userMapper = DatabaseOperation.session.getMapper(UserMapper.class);
        userMapper.UpdateUser(user);
    }

    public static boolean oldPasswordIsRight(String ID, String oldPassword) throws Exception {
        return UserLogin.verifyPassword(ID, oldPassword);
    }

    public static boolean checkPassword(String password) {
        return UserRegister.checkPassword(password);
    }

    public static void updateUserNewPassword(String ID, String newPassword) {
        UserMapper userMapper = DatabaseOperation.session.getMapper(UserMapper.class);
        userMapper.UpdatePassword(ID, newPassword);
    }
}

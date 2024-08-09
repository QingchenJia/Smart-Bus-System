package SmartBusSystem.service.function;

import SmartBusSystem.mapper.BusMapper;
import SmartBusSystem.mapper.RouteMapper;
import SmartBusSystem.pojo.Bus;
import SmartBusSystem.pojo.Route;
import SmartBusSystem.service.tool.DatabaseOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

@Slf4j
public class AdminEditBus {
    private static final SqlSession sqlSession;
    private static final BusMapper busMapper;
    private static final RouteMapper routeMapper;

    static {
        sqlSession = DatabaseOperation.getSqlSession();
        busMapper = sqlSession.getMapper(BusMapper.class);
        routeMapper = sqlSession.getMapper(RouteMapper.class);
    }

    public static List<Bus> queryAllBus() {
        List<Bus> buses = busMapper.SelectAll();
        log.info("全部车辆->" + buses);
        return buses;
    }

    public static List<String> listBus2listBusLicenseNumber(List<Bus> buses) {
        return buses.stream().map(Bus::getLicenseNumber).toList();
    }

    public static Bus queryBusById(String licenseNum) {
        return DriverHomePage.queryBusById(licenseNum);
    }

    public static void updateBusStatus(Bus bus) {
        busMapper.UpdateBusStatus(bus);
        sqlSession.commit();
    }

    public static boolean checkLicenseNumber(String licenseNum) {
        String licenseNumberRegex = "[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵青藏川宁琼]([A-Z][A-HJ-NP-Z0-9]{4}[A-HJ-NP-Z0-9挂学警港澳使领]|[DF][A-HJ-NP-Z0-9]{5})";
        return licenseNum.matches(licenseNumberRegex);
    }

    public static List<Route> queryRouteStatusIsOne() {
        List<Route> routes = routeMapper.SelectStatusIsOne();
        log.info("正常路线->" + routes);
        return routes;
    }

    public static List<String> listRoute2listRouteId(List<Route> routes) {
        return routes.stream().map(route -> route.getID() + "路").toList();
    }

    public static void addNewBus(Bus bus) {
        busMapper.InsertBus(bus);
        sqlSession.commit();
    }

    public static boolean containBus(String licenseNum) {
        return DriverHomePage.queryBusById(licenseNum) != null;
    }

    public static void deleteBus(String licenseNum) {
        busMapper.DeleteBus(licenseNum);
        sqlSession.commit();
    }
}

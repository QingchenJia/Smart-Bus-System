package SmartBusSystem.service.function;

import SmartBusSystem.dao.BusDao;
import SmartBusSystem.dao.RouteDao;
import SmartBusSystem.dao.impl.BusDaoImpl;
import SmartBusSystem.dao.impl.RouteDaoImpl;
import SmartBusSystem.pojo.Bus;
import SmartBusSystem.pojo.Route;

import java.util.List;

public class AdminEditBus {
    private static final BusDao busDao = new BusDaoImpl();
    private static final RouteDao routeDao = new RouteDaoImpl();

    public static List<Bus> queryAllBus() {
        return busDao.SelectAll();
    }

    public static List<String> listBus2listBusLicenseNumber(List<Bus> buses) {
        return buses.stream().map(Bus::getLicenseNumber).toList();
    }

    public static Bus queryBusById(String licenseNum) {
        return DriverHomePage.queryBusById(licenseNum);
    }

    public static void updateBusStatus(Bus bus) {
        busDao.UpdateBusStatus(bus);
    }

    public static boolean checkLicenseNumber(String licenseNum) {
        String licenseNumberRegex = "[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵青藏川宁琼]([A-Z][A-HJ-NP-Z0-9]{4}[A-HJ-NP-Z0-9挂学警港澳使领]|[DF][A-HJ-NP-Z0-9]{5})";
        return licenseNum.matches(licenseNumberRegex);
    }

    public static List<Route> queryRouteStatusIsOne() {
        return routeDao.SelectStatusIsOne();
    }

    public static List<String> listRoute2listRouteId(List<Route> routes) {
        return routes.stream().map(route -> route.getID() + "路").toList();
    }

    public static void addNewBus(Bus bus) {
        busDao.InsertBus(bus);
    }

    public static boolean containBus(String licenseNum) {
        return DriverHomePage.queryBusById(licenseNum) != null;
    }

    public static void deleteBus(String licenseNum) {
        busDao.DeleteBus(licenseNum);
    }
}

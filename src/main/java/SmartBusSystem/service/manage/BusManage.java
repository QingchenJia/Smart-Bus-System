package SmartBusSystem.service.manage;

import SmartBusSystem.dao.BusDao;
import SmartBusSystem.dao.RouteDao;
import SmartBusSystem.dao.impl.BusDaoImpl;
import SmartBusSystem.dao.impl.RouteDaoImpl;
import SmartBusSystem.pojo.Bus;
import SmartBusSystem.pojo.Route;

import java.util.List;

public class BusManage {
    private static final BusDao busDao = new BusDaoImpl();
    private static final RouteDao routeDao = new RouteDaoImpl();

    public List<Bus> queryAllBus() {
        return busDao.SelectAll();
    }

    public List<String> listBus2listBusLicenseNumber(List<Bus> buses) {
        return buses.stream().map(Bus::getLicenseNumber).toList();
    }

    public Bus queryBusById(String licenseNum) {
        return busDao.SelectByLicenseNumber(licenseNum);
    }

    public void updateBusStatus(Bus bus) {
        busDao.UpdateBusStatus(bus);
    }

    public boolean checkLicenseNumber(String licenseNum) {
        String licenseNumberRegex = "[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵青藏川宁琼]([A-Z][A-HJ-NP-Z0-9]{4}[A-HJ-NP-Z0-9挂学警港澳使领]|[DF][A-HJ-NP-Z0-9]{5})";
        return licenseNum.matches(licenseNumberRegex);
    }

    public List<Route> queryRouteStatusIsOne() {
        return routeDao.SelectStatusIsOne();
    }

    public List<String> listRoute2listRouteId(List<Route> routes) {
        return routes.stream().map(route -> route.getID() + "路").toList();
    }

    public void addNewBus(Bus bus) {
        busDao.InsertBus(bus);
    }

    public boolean containBus(String licenseNum) {
        return busDao.SelectBusAvailable(licenseNum) != null;
    }

    public void deleteBus(String licenseNum) {
        busDao.DeleteBus(licenseNum);
    }
}

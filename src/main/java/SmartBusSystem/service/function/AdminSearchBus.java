package SmartBusSystem.service.function;

import SmartBusSystem.mapper.BusMapper;
import SmartBusSystem.pojo.Bus;
import SmartBusSystem.pojo.Driver;
import SmartBusSystem.service.DatabaseOperation;

import java.util.List;

public class AdminSearchBus {
    public static List<Bus> queryAllBus() {
        BusMapper busMapper = DatabaseOperation.session.getMapper(BusMapper.class);
        List<Bus> buses = busMapper.SelectAll();
        System.out.println("全部车辆->" + buses);
        return buses;
    }

    public static List<String> listBus2listBusLicenseNumber(List<Bus> buses) {
        return buses.stream().map(Bus::getLicenseNumber).toList();
    }

    public static Bus queryBusById(String licenseNum) {
        return DriverHomePage.queryBusById(licenseNum);
    }

    public static void updateBusStatus(Bus bus) {
        BusMapper busMapper = DatabaseOperation.session.getMapper(BusMapper.class);
        busMapper.UpdateBusStatus(bus);
        DatabaseOperation.session.commit();
    }
}

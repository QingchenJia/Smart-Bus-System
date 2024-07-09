package SmartBusSystem.service.function;

import SmartBusSystem.mapper.DriverMapper;
import SmartBusSystem.pojo.Driver;
import SmartBusSystem.service.DatabaseOperation;

public class DriverHomePage {
    public static Driver queryCurrentDriverInformation(String DID) {
        DriverMapper driverMapper = DatabaseOperation.session.getMapper(DriverMapper.class);
        Driver driver = driverMapper.SelectById(DID);
        System.out.println("当前司机->" + driver);
        return driver;
    }
}

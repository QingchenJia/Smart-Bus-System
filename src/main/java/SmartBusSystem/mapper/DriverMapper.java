package SmartBusSystem.mapper;

import SmartBusSystem.pojo.Driver;
import SmartBusSystem.pojo.User;

import java.util.List;

public interface DriverMapper {
    List<Driver> SelectAll();
    Driver SelectById(String ID);
    void InsertDriver(Driver driver);
}

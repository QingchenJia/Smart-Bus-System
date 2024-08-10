package SmartBusSystem.dao;

import SmartBusSystem.pojo.Driver;

import java.util.List;

public interface DriverDao {
    List<Driver> SelectAll();

    Driver SelectById(String ID);

    List<Driver> SelectDriverAvailable(String time);

    List<Driver> SelectDriverIsArranged(String time);

    void InsertDriver(Driver driver);

    void UpdateDriver(Driver driver);

    void UpdatePassword(String ID, String password);
}

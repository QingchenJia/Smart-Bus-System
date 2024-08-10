package SmartBusSystem.dao;

import SmartBusSystem.pojo.Bus;

import java.util.List;

public interface BusDao {
    List<Bus> SelectAll();

    Bus SelectByLicenseNumber(String licenseNumber);

    List<Bus> SelectBusAvailable(String dayOfWeek);

    void InsertBus(Bus bus);

    void UpdateBusStatus(Bus bus);

    void DeleteBus(String licenseNumber);
}

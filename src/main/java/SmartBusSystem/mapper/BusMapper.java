package SmartBusSystem.mapper;

import SmartBusSystem.pojo.Bus;

import java.util.List;

public interface BusMapper {
    List<Bus> SelectAll();
    Bus SelectByLicenseNumber(String licenseNumber);
    void InsertBus(Bus bus);

    void UpdateBusStatus(Bus bus);
}

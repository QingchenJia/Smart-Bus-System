package SmartBusSystem.mapper;

import SmartBusSystem.pojo.Bus;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BusMapper {
    List<Bus> SelectAll();

    Bus SelectByLicenseNumber(@Param("licenseNumber") String licenseNumber);

    List<Bus> SelectBusAvailable(@Param("time") String dayOfWeek);

    void InsertBus(Bus bus);

    void UpdateBusStatus(Bus bus);

    void DeleteBus(@Param("licenseNumber") String licenseNumber);
}

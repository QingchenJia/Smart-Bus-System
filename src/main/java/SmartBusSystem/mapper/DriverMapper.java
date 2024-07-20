package SmartBusSystem.mapper;

import SmartBusSystem.pojo.Driver;
import SmartBusSystem.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DriverMapper {
    List<Driver> SelectAll();

    Driver SelectById(String ID);

    List<Driver> SelectDriverAvailable(@Param("time") String time);
    List<Driver> SelectDriverIsArranged(@Param("time") String time);

    void InsertDriver(Driver driver);

    void UpdateDriver(Driver driver);

    void UpdatePassword(@Param("ID") String ID, @Param("password") String password);
}

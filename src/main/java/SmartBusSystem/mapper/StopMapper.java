package SmartBusSystem.mapper;

import SmartBusSystem.pojo.Stop;

import java.util.List;

public interface StopMapper {
    List<Stop> SelectAll();

    Stop SelectById(String ID);

    void InsertStop(Stop stop);
}

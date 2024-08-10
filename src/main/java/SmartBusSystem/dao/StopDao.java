package SmartBusSystem.dao;

import SmartBusSystem.pojo.Stop;

import java.util.List;

public interface StopDao {
    List<Stop> SelectAll();

    Stop SelectById(String ID);

    void InsertStop(Stop stop);

    List<Stop> SelectStopOrderInRoute(String RID);

    List<Stop> SelectStopBySimilarName(String similarName);

    Stop SelectByName(String name);
}

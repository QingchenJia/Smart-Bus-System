package SmartBusSystem.mapper;

import SmartBusSystem.pojo.Stop;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StopMapper {
    List<Stop> SelectAll();

    Stop SelectById(String ID);

    void InsertStop(Stop stop);

    List<Stop> SelectStopOrderInRoute(@Param("RID") String RID);

    List<Stop> SelectStopBySimilarName(@Param("similarName") String similarName);
}

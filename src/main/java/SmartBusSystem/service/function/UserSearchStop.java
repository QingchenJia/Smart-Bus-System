package SmartBusSystem.service.function;

import SmartBusSystem.mapper.StopMapper;
import SmartBusSystem.pojo.Stop;
import SmartBusSystem.service.DatabaseOperation;

import java.util.List;

public class UserSearchStop {
    public static List<Stop> searchBySimilarName(String similarName) {
        StopMapper stopMapper = DatabaseOperation.session.getMapper(StopMapper.class);
        List<Stop> stops = stopMapper.SelectStopBySimilarName(similarName);
        System.out.println("模糊匹配->" + stops);
        return stops;
    }

    public static List<String> listStop2listStopName(List<Stop> stops) {
        return stops.stream().map(Stop::getName).toList();
    }
}

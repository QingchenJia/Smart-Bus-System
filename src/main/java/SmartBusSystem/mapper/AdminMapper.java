package SmartBusSystem.mapper;

import SmartBusSystem.pojo.Admin;
import org.apache.ibatis.annotations.Select;

public interface AdminMapper {
    Admin SelectById(String ID);
}

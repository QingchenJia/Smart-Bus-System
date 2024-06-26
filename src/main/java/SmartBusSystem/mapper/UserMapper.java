package SmartBusSystem.mapper;

import SmartBusSystem.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> SelectAll();

    User SelectById(String ID);

    List<User> SelectByAptitude(int aptitude);
}

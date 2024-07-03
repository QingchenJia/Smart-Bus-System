package SmartBusSystem.mapper;

import SmartBusSystem.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    List<User> SelectAll();

    User SelectById(String ID);

    List<User> SelectByAptitude(int aptitude);

    void InsertUser(User user);

    void UpdateUser(User user);

    void UpdatePassword(@Param("ID") String ID, @Param("password") String password);
}

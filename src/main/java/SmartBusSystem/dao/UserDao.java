package SmartBusSystem.dao;

import SmartBusSystem.pojo.User;

import java.util.List;

public interface UserDao {
    List<User> SelectAll();

    User SelectById(String ID);

    List<User> SelectByAptitude(int aptitude);

    void InsertUser(User user);

    void UpdateUser(User user);

    void UpdatePassword(String ID, String password);
}

package SmartBusSystem.service.function;

import SmartBusSystem.mapper.UserMapper;
import SmartBusSystem.pojo.User;
import SmartBusSystem.service.DatabaseOperation;

public class UserFunction {
    public static User queryCurrentUserInformation(String ID) {
        UserMapper userMapper = DatabaseOperation.session.getMapper(UserMapper.class);
        User user = userMapper.SelectById(ID);
        System.out.println(user);
        return user;
    }
}

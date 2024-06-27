package SmartBusSystem.service.register;

import SmartBusSystem.mapper.UserMapper;
import SmartBusSystem.pojo.User;
import SmartBusSystem.service.DatabaseOperation;

public class UserRegister {
    public static boolean containUser(String ID) {
        UserMapper userMapper = DatabaseOperation.session.getMapper(UserMapper.class);
        User userResult = userMapper.SelectById(ID);
        return userResult != null;
    }

    public static boolean checkID(String ID) {
        return ID.matches("[A-Za-z0-9]{6,10}");
    }

    public static boolean checkPassword(String password) {
        return password.matches("[A-Za-z0-9@#&.]{6,}");
    }

    public static boolean checkPhoneNum(String phoneNum) {
        return phoneNum.matches("[1]\\d{10}");
    }

    public static void register(User user) {
        UserMapper userMapper = DatabaseOperation.session.getMapper(UserMapper.class);
        userMapper.InsertUser(user);
        DatabaseOperation.session.commit();
    }
}

package SmartBusSystem.service.register;

import SmartBusSystem.mapper.UserMapper;
import SmartBusSystem.pojo.User;
import SmartBusSystem.service.DatabaseOperation;

public class UserRegister {
    public static boolean containUser(String ID) {
        UserMapper userMapper = DatabaseOperation.session.getMapper(UserMapper.class);
        User user = userMapper.SelectById(ID);
        System.out.println(user);   // 控制台展示查询结果
        return user != null;
    }

    public static boolean checkID(String ID) {
        return ID.matches("[A-Za-z0-9]{6,10}");
    }

    public static boolean checkPassword(String password) {
        return password.matches("[A-Za-z0-9@#.]{6,20}");
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

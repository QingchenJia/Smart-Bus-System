package SmartBusSystem.service.login;

import SmartBusSystem.mapper.UserMapper;
import SmartBusSystem.pojo.User;
import SmartBusSystem.service.DatabaseOperation;
import SmartBusSystem.service.SecurityProtect;
import SmartBusSystem.service.register.UserRegister;

import java.net.IDN;

public class UserLogin {
    public static boolean verifyID(String ID) {
        return UserRegister.containUser(ID);
    }

    public static boolean verifyPassword(String ID, String password) throws Exception {
        UserMapper userMapper = DatabaseOperation.session.getMapper(UserMapper.class);
        User user = userMapper.SelectById(ID);
        System.out.println(user);   // 控制台展示查询结果
        return password.equals(SecurityProtect.decrypt(user.getPassword()));
    }

    public static boolean verifyVerifyCode(String code, String rightCode) {
        return rightCode.equals(code);
    }

    public static boolean verifyPhoneNum(String ID, String phoneNum) {
        UserMapper userMapper = DatabaseOperation.session.getMapper(UserMapper.class);
        User user = userMapper.SelectById(ID);
        System.out.println(user);   // 控制台展示查询结果
        return phoneNum.equals(user.getPhoneNum());
    }

    public static boolean checkPassword(String password) {
        return UserRegister.checkPassword(password);
    }

    public static void resetPassword(String ID, String newPassword) {
        UserMapper userMapper = DatabaseOperation.session.getMapper(UserMapper.class);
        userMapper.UpdatePassword(ID, newPassword);
    }
}

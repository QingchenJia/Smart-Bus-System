package SmartBusSystem.service.recover;

import SmartBusSystem.mapper.UserMapper;
import SmartBusSystem.pojo.User;
import SmartBusSystem.service.DatabaseOperation;
import SmartBusSystem.service.login.UserLogin;
import SmartBusSystem.service.register.UserRegister;

public class UserRecover {
    public static boolean verifyID(String ID) {
        return UserLogin.verifyID(ID);
    }

    public static boolean verifyPhoneNum(String ID, String phoneNum) {
        UserMapper userMapper = DatabaseOperation.session.getMapper(UserMapper.class);
        User user = userMapper.SelectById(ID);
        System.out.println("验证手机号->" + user);   // 控制台展示查询结果
        return phoneNum.equals(user.getPhoneNum());
    }

    public static boolean checkPassword(String password) {
        return UserRegister.checkPassword(password);
    }

    public static void resetPassword(String ID, String newPassword) {
        UserMapper userMapper = DatabaseOperation.session.getMapper(UserMapper.class);
        userMapper.UpdatePassword(ID, newPassword);
        DatabaseOperation.session.commit();
    }
}

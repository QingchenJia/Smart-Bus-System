package SmartBusSystem.service.function;

import SmartBusSystem.mapper.UserMapper;
import SmartBusSystem.pojo.User;
import SmartBusSystem.service.tool.DatabaseOperation;
import SmartBusSystem.service.login.UserLogin;
import SmartBusSystem.service.register.UserRegister;

public class UserInformationModify {
    private static final UserMapper userMapper;

    static {
        userMapper = DatabaseOperation.session.getMapper(UserMapper.class);
    }

    public static boolean checkPhoneNum(String phoneNum) {
        return UserRegister.checkPhoneNum(phoneNum);
    }

    public static void updateUserInformation(User user) {   // 更新用户基本信息
        userMapper.UpdateUser(user);
        DatabaseOperation.session.commit();
    }

    public static boolean oldPasswordIsRight(String ID, String oldPassword) throws Exception {
        return UserLogin.verifyPassword(ID, oldPassword);
    }

    public static boolean checkPassword(String password) {
        return UserRegister.checkPassword(password);
    }

    public static void updateUserNewPassword(String ID, String newPassword) {   // 修改密码
        userMapper.UpdatePassword(ID, newPassword);
        DatabaseOperation.session.commit();
    }
}

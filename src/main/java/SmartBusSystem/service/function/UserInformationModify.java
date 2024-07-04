package SmartBusSystem.service.function;

import SmartBusSystem.mapper.UserMapper;
import SmartBusSystem.pojo.User;
import SmartBusSystem.service.DatabaseOperation;
import SmartBusSystem.service.login.UserLogin;
import SmartBusSystem.service.register.UserRegister;

public class UserInformationModify {
    public static boolean checkPhoneNum(String phoneNum) {
        return UserRegister.checkPhoneNum(phoneNum);
    }

    public static void updateUserInformation(User user) {   // 更新用户基本信息
        UserMapper userMapper = DatabaseOperation.session.getMapper(UserMapper.class);
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
        UserMapper userMapper = DatabaseOperation.session.getMapper(UserMapper.class);
        userMapper.UpdatePassword(ID, newPassword);
        DatabaseOperation.session.commit();
    }
}

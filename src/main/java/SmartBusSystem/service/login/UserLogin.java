package SmartBusSystem.service.login;

import SmartBusSystem.mapper.UserMapper;
import SmartBusSystem.pojo.User;
import SmartBusSystem.service.DatabaseOperation;
import SmartBusSystem.service.SecurityProtect;
import SmartBusSystem.service.register.UserRegister;

public class UserLogin {
    public static boolean verifyID(String ID) {
        return UserRegister.containUser(ID);
    }

    public static boolean verifyPassword(String ID, String password) throws Exception {
        UserMapper userMapper = DatabaseOperation.session.getMapper(UserMapper.class);
        User user = userMapper.SelectById(ID);
        return password.equals(SecurityProtect.decrypt(user.getPassword()));
    }

    public static boolean verifyVerifyCode(String code, String rightCode) {
        return rightCode.equals(code);
    }
}

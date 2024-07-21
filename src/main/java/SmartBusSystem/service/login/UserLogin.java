package SmartBusSystem.service.login;

import SmartBusSystem.mapper.UserMapper;
import SmartBusSystem.pojo.User;
import SmartBusSystem.service.DatabaseOperation;
import SmartBusSystem.service.SecurityProtect;
import SmartBusSystem.service.register.UserRegister;

public class UserLogin {
    public static final UserMapper userMapper;

    static {
        userMapper = DatabaseOperation.session.getMapper(UserMapper.class);
    }

    public static boolean verifyID(String ID) {
        return UserRegister.containUser(ID);
    }

    public static boolean verifyPassword(String ID, String password) throws Exception {
        User user = userMapper.SelectById(ID);
        System.out.println("验证密码->" + user);   // 控制台展示查询结果
        return password.equals(SecurityProtect.decrypt(user.getPassword()));
    }

    public static boolean verifyVerifyCode(String code, String rightCode) {
        return rightCode.equals(code);
    }
}

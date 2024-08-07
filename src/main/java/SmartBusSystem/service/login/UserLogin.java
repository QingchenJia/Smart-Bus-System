package SmartBusSystem.service.login;

import SmartBusSystem.mapper.UserMapper;
import SmartBusSystem.pojo.User;
import SmartBusSystem.service.register.UserRegister;
import SmartBusSystem.service.tool.DatabaseOperation;
import SmartBusSystem.service.tool.SecurityProtect;
import org.apache.ibatis.session.SqlSession;

public class UserLogin {
    private static final SqlSession sqlSession;
    public static final UserMapper userMapper;

    static {
        sqlSession = DatabaseOperation.getSqlSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
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

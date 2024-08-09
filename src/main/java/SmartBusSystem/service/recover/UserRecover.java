package SmartBusSystem.service.recover;

import SmartBusSystem.mapper.UserMapper;
import SmartBusSystem.pojo.User;
import SmartBusSystem.service.login.UserLogin;
import SmartBusSystem.service.register.UserRegister;
import SmartBusSystem.service.tool.DatabaseOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;

@Slf4j
public class UserRecover {
    private static final SqlSession sqlSession;
    public static final UserMapper userMapper;

    static {
        sqlSession = DatabaseOperation.getSqlSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    public static boolean verifyID(String ID) {
        return UserLogin.verifyID(ID);
    }

    public static boolean verifyPhoneNum(String ID, String phoneNum) {
        User user = userMapper.SelectById(ID);
        log.info("验证手机号->" + user);   // 控制台展示查询结果
        return phoneNum.equals(user.getPhoneNum());
    }

    public static boolean checkPassword(String password) {
        return UserRegister.checkPassword(password);
    }

    public static void resetPassword(String ID, String newPassword) {
        userMapper.UpdatePassword(ID, newPassword);
        sqlSession.commit();
    }
}

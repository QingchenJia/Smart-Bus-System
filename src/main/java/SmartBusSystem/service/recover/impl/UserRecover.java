package SmartBusSystem.service.recover.impl;

import SmartBusSystem.mapper.UserMapper;
import SmartBusSystem.pojo.User;
import SmartBusSystem.service.recover.Recover;
import SmartBusSystem.service.register.impl.UserRegister;
import SmartBusSystem.service.tool.DatabaseOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;

@Slf4j
public class UserRecover implements Recover {
    private static final SqlSession sqlSession;
    public static final UserMapper userMapper;

    static {
        sqlSession = DatabaseOperation.getSqlSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    public boolean verifyID(String ID) {
        User user = userMapper.SelectById(ID);
        log.info("检索用户->" + user);   // 控制台展示查询结果
        return user != null;
    }

    public boolean verifyPhoneNum(String ID, String phoneNum) {
        User user = userMapper.SelectById(ID);
        log.info("验证手机号->" + user);   // 控制台展示查询结果
        return phoneNum.equals(user.getPhoneNum());
    }

    public boolean checkPassword(String password) {
        return new UserRegister().checkPassword(password);
    }

    public void resetPassword(String ID, String newPassword) {
        userMapper.UpdatePassword(ID, newPassword);
        sqlSession.commit();
    }
}

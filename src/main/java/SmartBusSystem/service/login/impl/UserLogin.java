package SmartBusSystem.service.login.impl;

import SmartBusSystem.mapper.UserMapper;
import SmartBusSystem.pojo.User;
import SmartBusSystem.service.login.Login;
import SmartBusSystem.service.register.impl.UserRegister;
import SmartBusSystem.service.tool.DatabaseOperation;
import SmartBusSystem.service.tool.SecurityProtect;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;

@Slf4j
public class UserLogin implements Login {
    private static final SqlSession sqlSession;
    public static final UserMapper userMapper;

    static {
        sqlSession = DatabaseOperation.getSqlSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @Override
    public boolean verifyID(String ID) {
        return new UserRegister().containObject(ID);
    }

    @Override
    public boolean verifyPassword(String ID, String password) throws Exception {
        User user = userMapper.SelectById(ID);
        log.info("验证密码->" + user);   // 控制台展示查询结果
        return password.equals(SecurityProtect.decrypt(user.getPassword()));
    }

    @Override
    public boolean verifyVerifyCode(String code, String rightCode) {
        return rightCode.equals(code);
    }
}

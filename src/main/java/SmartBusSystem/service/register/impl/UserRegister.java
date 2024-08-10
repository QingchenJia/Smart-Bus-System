package SmartBusSystem.service.register.impl;

import SmartBusSystem.mapper.UserMapper;
import SmartBusSystem.pojo.User;
import SmartBusSystem.service.register.Register;
import SmartBusSystem.service.tool.DatabaseOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;

@Slf4j
public class UserRegister implements Register {
    private static final SqlSession sqlSession;
    public static final UserMapper userMapper;

    static {
        sqlSession = DatabaseOperation.getSqlSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @Override
    public boolean containObject(String ID) {
        User user = userMapper.SelectById(ID);
        log.info("检索用户->" + user);   // 控制台展示查询结果
        return user != null;
    }

    @Override
    public boolean checkID(String ID) {
        return ID.matches("[A-Za-z0-9]{6,10}");
    }

    @Override
    public boolean checkPassword(String password) {
        return password.matches("[A-Za-z0-9@#.]{6,20}");
    }

    @Override
    public boolean checkPhoneNum(String phoneNum) {
        return phoneNum.matches("[1]\\d{10}");
    }

    @Override
    public void register(Object object) {
        userMapper.InsertUser((User) object);
        sqlSession.commit();
    }
}

package SmartBusSystem.dao.impl;

import SmartBusSystem.dao.UserDao;
import SmartBusSystem.mapper.UserMapper;
import SmartBusSystem.pojo.User;
import SmartBusSystem.Util.DatabaseUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private static final SqlSession sqlSession;
    private static final UserMapper userMapper;

    static {
        sqlSession = DatabaseUtil.getSqlSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @Override
    public List<User> SelectAll() {
        return userMapper.SelectAll();
    }

    @Override
    public User SelectById(String ID) {
        return userMapper.SelectById(ID);
    }

    @Override
    public List<User> SelectByAptitude(int aptitude) {
        return userMapper.SelectByAptitude(aptitude);
    }

    @Override
    public void InsertUser(User user) {
        userMapper.InsertUser(user);
        sqlSession.commit();
    }

    @Override
    public void UpdateUser(User user) {
        userMapper.UpdateUser(user);
        sqlSession.commit();
    }

    @Override
    public void UpdatePassword(String ID, String password) {
        userMapper.UpdatePassword(ID, password);
        sqlSession.commit();
    }
}

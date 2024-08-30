package SmartBusSystem.dao.impl;

import SmartBusSystem.dao.UserDao;
import SmartBusSystem.mapper.UserMapper;
import SmartBusSystem.pojo.User;
import SmartBusSystem.Util.DatabaseOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

@Slf4j
public class UserDaoImpl implements UserDao {
    private static final SqlSession sqlSession;
    private static final UserMapper userMapper;

    static {
        sqlSession = DatabaseOperation.getSqlSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @Override
    public List<User> SelectAll() {
        List<User> users = userMapper.SelectAll();
        log.info("所有用户->" + users);
        return users;
    }

    @Override
    public User SelectById(String ID) {
        User user = userMapper.SelectById(ID);
        log.info("当前用户->" + user);   // 控制台展示查询结果
        return user;
    }

    @Override
    public List<User> SelectByAptitude(int aptitude) {
        List<User> users = userMapper.SelectByAptitude(aptitude);
        log.info("同一资质用户->" + users);
        return users;
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

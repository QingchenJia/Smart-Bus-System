package SmartBusSystem.service.register;

import SmartBusSystem.mapper.UserMapper;
import SmartBusSystem.pojo.User;
import SmartBusSystem.service.tool.DatabaseOperation;
import org.apache.ibatis.session.SqlSession;

public class UserRegister {
    private static final SqlSession sqlSession;
    public static final UserMapper userMapper;

    static {
        sqlSession = DatabaseOperation.getSqlSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    public static boolean containUser(String ID) {
        User user = userMapper.SelectById(ID);
        System.out.println("检索用户->" + user);   // 控制台展示查询结果
        return user != null;
    }

    public static boolean checkID(String ID) {
        return ID.matches("[A-Za-z0-9]{6,10}");
    }

    public static boolean checkPassword(String password) {
        return password.matches("[A-Za-z0-9@#.]{6,20}");
    }

    public static boolean checkPhoneNum(String phoneNum) {
        return phoneNum.matches("[1]\\d{10}");
    }

    public static void register(User user) {
        userMapper.InsertUser(user);
        sqlSession.commit();
    }
}

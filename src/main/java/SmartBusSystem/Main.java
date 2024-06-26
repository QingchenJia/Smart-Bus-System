package SmartBusSystem;

import SmartBusSystem.mapper.AdminMapper;
import SmartBusSystem.mapper.UserMapper;
import SmartBusSystem.pojo.Admin;
import SmartBusSystem.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String resource = "MybatisConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        try (SqlSession session = sqlSessionFactory.openSession()) {
            AdminMapper adminMapper = session.getMapper(AdminMapper.class);
            Admin admin = adminMapper.SelectById("admin01");
            System.out.println(admin);
//            UserMapper userMapper = session.getMapper(UserMapper.class);
            /*List<User> users = userMapper.SelectAll();
            System.out.println(users);*/
            /*User user = userMapper.SelectById("1111");
            System.out.println(user);*/
            /*List<User> users = userMapper.SelectByAptitude(1);
            System.out.println(users);*/
        }
    }
}

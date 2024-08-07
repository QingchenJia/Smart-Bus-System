package SmartBusSystem.service.login;

import SmartBusSystem.mapper.AdminMapper;
import SmartBusSystem.pojo.Admin;
import SmartBusSystem.service.tool.DatabaseOperation;
import SmartBusSystem.service.tool.SecurityProtect;
import org.apache.ibatis.session.SqlSession;

public class AdminLogin {
    private static final SqlSession sqlSession;
    private static final AdminMapper adminMapper;

    static {
        sqlSession = DatabaseOperation.getSqlSession();
        adminMapper = sqlSession.getMapper(AdminMapper.class);
    }

    public static boolean verifyID(String ID) {
        Admin admin = adminMapper.SelectById(ID);
        System.out.println("检索管理员->" + admin);  // 控制台展示查询结果
        return admin != null;
    }

    public static boolean verifyPassword(String ID, String password) throws Exception {
        Admin admin = adminMapper.SelectById(ID);
        System.out.println("验证密码->" + admin);  // 控制台展示查询结果
        return password.equals(SecurityProtect.decrypt(admin.getPassword()));
    }
}

package SmartBusSystem.service.login;

import SmartBusSystem.mapper.AdminMapper;
import SmartBusSystem.pojo.Admin;
import SmartBusSystem.service.tool.DatabaseOperation;
import SmartBusSystem.service.tool.SecurityProtect;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;

@Slf4j
public class AdminLogin {
    private static final SqlSession sqlSession;
    private static final AdminMapper adminMapper;

    static {
        sqlSession = DatabaseOperation.getSqlSession();
        adminMapper = sqlSession.getMapper(AdminMapper.class);
    }

    public static boolean verifyID(String ID) {
        Admin admin = adminMapper.SelectById(ID);
        log.info("检索管理员->" + admin);  // 控制台展示查询结果
        return admin != null;
    }

    public static boolean verifyPassword(String ID, String password) throws Exception {
        Admin admin = adminMapper.SelectById(ID);
        log.info("验证密码->" + admin);  // 控制台展示查询结果
        return password.equals(SecurityProtect.decrypt(admin.getPassword()));
    }
}

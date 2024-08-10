package SmartBusSystem.service.login.impl;

import SmartBusSystem.mapper.AdminMapper;
import SmartBusSystem.pojo.Admin;
import SmartBusSystem.service.login.Login;
import SmartBusSystem.service.tool.DatabaseOperation;
import SmartBusSystem.service.tool.SecurityProtect;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;

@Slf4j
public class AdminLogin implements Login {
    private static final SqlSession sqlSession;
    private static final AdminMapper adminMapper;

    static {
        sqlSession = DatabaseOperation.getSqlSession();
        adminMapper = sqlSession.getMapper(AdminMapper.class);
    }

    @Override
    public boolean verifyID(String ID) {
        Admin admin = adminMapper.SelectById(ID);
        log.info("检索管理员->" + admin);  // 控制台展示查询结果
        return admin != null;
    }

    @Override
    public boolean verifyPassword(String ID, String password) throws Exception {
        Admin admin = adminMapper.SelectById(ID);
        log.info("验证密码->" + admin);  // 控制台展示查询结果
        return password.equals(SecurityProtect.decrypt(admin.getPassword()));
    }

    @Override
    public boolean verifyVerifyCode(String code, String rightCode) {
        return false;
    }
}

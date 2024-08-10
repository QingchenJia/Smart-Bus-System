package SmartBusSystem.service.login.impl;

import SmartBusSystem.mapper.DriverMapper;
import SmartBusSystem.pojo.Driver;
import SmartBusSystem.service.login.Login;
import SmartBusSystem.service.tool.DatabaseOperation;
import SmartBusSystem.service.tool.SecurityProtect;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;

@Slf4j
public class DriverLogin implements Login {
    private static final SqlSession sqlSession;
    private static final DriverMapper driverMapper;

    static {
        sqlSession = DatabaseOperation.getSqlSession();
        driverMapper = sqlSession.getMapper(DriverMapper.class);
    }

    public boolean verifyID(String ID) {
        Driver driver = driverMapper.SelectById(ID);
        log.info("检索司机->" + driver);  // 控制台展示查询结果
        return driver != null;
    }

    public boolean verifyPassword(String ID, String password) throws Exception {
        Driver driver = driverMapper.SelectById(ID);
        log.info("验证密码->" + driver);  // 控制台展示查询结果
        return password.equals(SecurityProtect.decrypt(driver.getPassword()));
    }

    public boolean verifyVerifyCode(String code, String rightCode) {
        return rightCode.equals(code);
    }
}

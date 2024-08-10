package SmartBusSystem.service.recover.impl;

import SmartBusSystem.mapper.DriverMapper;
import SmartBusSystem.pojo.Driver;
import SmartBusSystem.service.recover.Recover;
import SmartBusSystem.service.register.impl.DriverRegister;
import SmartBusSystem.service.tool.DatabaseOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;

@Slf4j
public class DriverRecover implements Recover {
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

    public boolean verifyPhoneNum(String ID, String phoneNum) {
        Driver driver = driverMapper.SelectById(ID);
        log.info("验证手机号->" + driver);   // 控制台展示查询结果
        return phoneNum.equals(driver.getPhoneNum());
    }

    public boolean checkPassword(String password) {
        return new DriverRegister().checkPassword(password);
    }

    public void resetPassword(String ID, String newPassword) {
        driverMapper.UpdatePassword(ID, newPassword);
        sqlSession.commit();
    }
}

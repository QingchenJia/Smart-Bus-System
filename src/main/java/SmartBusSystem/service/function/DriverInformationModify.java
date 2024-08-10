package SmartBusSystem.service.function;

import SmartBusSystem.mapper.DriverMapper;
import SmartBusSystem.pojo.Driver;
import SmartBusSystem.service.login.impl.DriverLogin;
import SmartBusSystem.service.register.impl.DriverRegister;
import SmartBusSystem.service.tool.DatabaseOperation;
import org.apache.ibatis.session.SqlSession;

public class DriverInformationModify {
    private static final SqlSession sqlSession;
    private static final DriverMapper driverMapper;

    static {
        sqlSession = DatabaseOperation.getSqlSession();
        driverMapper = sqlSession.getMapper(DriverMapper.class);
    }

    public static boolean checkPhoneNum(String phoneNum) {
        return phoneNum.matches("[1]\\d{10}");
    }

    public static void updateDriverInformation(Driver driver) {
        driverMapper.UpdateDriver(driver);
        sqlSession.commit();
    }

    public static boolean oldPasswordIsRight(String ID, String oldPassword) throws Exception {
        return new DriverLogin().verifyPassword(ID, oldPassword);
    }

    public static boolean checkPassword(String password) {
        return new DriverRegister().checkPassword(password);
    }

    public static void updateDriverNewPassword(String ID, String newPassword) {
        driverMapper.UpdatePassword(ID, newPassword);
        sqlSession.commit();
    }
}

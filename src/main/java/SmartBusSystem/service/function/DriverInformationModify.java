package SmartBusSystem.service.function;

import SmartBusSystem.mapper.DriverMapper;
import SmartBusSystem.pojo.Driver;
import SmartBusSystem.service.login.DriverLogin;
import SmartBusSystem.service.register.DriverRegister;
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
        return DriverRegister.checkPhoneNum(phoneNum);
    }

    public static void updateDriverInformation(Driver driver) {
        driverMapper.UpdateDriver(driver);
        sqlSession.commit();
    }

    public static boolean oldPasswordIsRight(String ID, String oldPassword) throws Exception {
        return DriverLogin.verifyPassword(ID, oldPassword);
    }

    public static boolean checkPassword(String password) {
        return DriverRegister.checkPassword(password);
    }

    public static void updateDriverNewPassword(String ID, String newPassword) {
        driverMapper.UpdatePassword(ID, newPassword);
        sqlSession.commit();
    }
}

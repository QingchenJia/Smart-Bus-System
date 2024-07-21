package SmartBusSystem.service.recover;

import SmartBusSystem.mapper.DriverMapper;
import SmartBusSystem.pojo.Driver;
import SmartBusSystem.service.DatabaseOperation;
import SmartBusSystem.service.login.DriverLogin;
import SmartBusSystem.service.register.DriverRegister;

public class DriverRecover {
    private static final DriverMapper driverMapper;

    static {
        driverMapper = DatabaseOperation.session.getMapper(DriverMapper.class);
    }

    public static boolean verifyID(String ID) {
        return DriverLogin.verifyID(ID);
    }

    public static boolean verifyPhoneNum(String ID, String phoneNum) {
        Driver driver = driverMapper.SelectById(ID);
        System.out.println("验证手机号->" + driver);   // 控制台展示查询结果
        return phoneNum.equals(driver.getPhoneNum());
    }

    public static boolean checkPassword(String password) {
        return DriverRegister.checkPassword(password);
    }

    public static void resetPassword(String ID, String newPassword) {
        driverMapper.UpdatePassword(ID, newPassword);
        DatabaseOperation.session.commit();
    }
}

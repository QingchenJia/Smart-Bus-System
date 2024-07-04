package SmartBusSystem.service.recover;

import SmartBusSystem.mapper.DriverMapper;
import SmartBusSystem.pojo.Driver;
import SmartBusSystem.service.DatabaseOperation;
import SmartBusSystem.service.login.DriverLogin;
import SmartBusSystem.service.register.DriverRegister;

public class DriverRecover {
    public static boolean verifyID(String ID) {
        return DriverLogin.verifyID(ID);
    }

    public static boolean verifyPhoneNum(String ID, String phoneNum) {
        DriverMapper driverMapper = DatabaseOperation.session.getMapper(DriverMapper.class);
        Driver driver = driverMapper.SelectById(ID);
        System.out.println(driver);   // 控制台展示查询结果
        return phoneNum.equals(driver.getPhoneNum());
    }

    public static boolean checkPassword(String password) {
        return DriverRegister.checkPassword(password);
    }

    public static void resetPassword(String ID, String newPassword) {
        DriverMapper driverMapper = DatabaseOperation.session.getMapper(DriverMapper.class);
        driverMapper.UpdatePassword(ID, newPassword);
        DatabaseOperation.session.commit();
    }
}

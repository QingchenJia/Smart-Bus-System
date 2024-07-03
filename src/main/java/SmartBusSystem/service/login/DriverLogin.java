package SmartBusSystem.service.login;

import SmartBusSystem.mapper.DriverMapper;
import SmartBusSystem.mapper.UserMapper;
import SmartBusSystem.pojo.Driver;
import SmartBusSystem.pojo.User;
import SmartBusSystem.service.DatabaseOperation;
import SmartBusSystem.service.SecurityProtect;
import SmartBusSystem.service.register.DriverRegister;
import SmartBusSystem.service.register.UserRegister;

public class DriverLogin {
    public static boolean verifyID(String ID) {
        return DriverRegister.containDriver(ID);
    }

    public static boolean verifyPassword(String ID, String password) throws Exception {
        DriverMapper driverMapper = DatabaseOperation.session.getMapper(DriverMapper.class);
        Driver driver = driverMapper.SelectById(ID);
        System.out.println(driver); // 控制台展示查询结果
        return password.equals(SecurityProtect.decrypt(driver.getPassword()));
    }

    public static boolean verifyVerifyCode(String code, String rightCode) {
        return UserLogin.verifyVerifyCode(code, rightCode);
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
    }
}

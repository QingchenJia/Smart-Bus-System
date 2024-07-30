package SmartBusSystem.service.login;

import SmartBusSystem.mapper.DriverMapper;
import SmartBusSystem.pojo.Driver;
import SmartBusSystem.service.tool.DatabaseOperation;
import SmartBusSystem.service.tool.SecurityProtect;
import SmartBusSystem.service.register.DriverRegister;

public class DriverLogin {
    private static final DriverMapper driverMapper;

    static {
        driverMapper = DatabaseOperation.session.getMapper(DriverMapper.class);
    }

    public static boolean verifyID(String ID) {
        return DriverRegister.containDriver(ID);
    }

    public static boolean verifyPassword(String ID, String password) throws Exception {
        Driver driver = driverMapper.SelectById(ID);
        System.out.println("验证密码->" + driver);  // 控制台展示查询结果
        return password.equals(SecurityProtect.decrypt(driver.getPassword()));
    }

    public static boolean verifyVerifyCode(String code, String rightCode) {
        return UserLogin.verifyVerifyCode(code, rightCode);
    }
}

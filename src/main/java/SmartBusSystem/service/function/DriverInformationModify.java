package SmartBusSystem.service.function;

import SmartBusSystem.mapper.DriverMapper;
import SmartBusSystem.pojo.Driver;
import SmartBusSystem.service.DatabaseOperation;
import SmartBusSystem.service.login.DriverLogin;
import SmartBusSystem.service.register.DriverRegister;

public class DriverInformationModify {
    public static boolean checkPhoneNum(String phoneNum) {
        return DriverRegister.checkPhoneNum(phoneNum);
    }

    public static void updateDriverInformation(Driver driver) {
        DriverMapper driverMapper = DatabaseOperation.session.getMapper(DriverMapper.class);
        driverMapper.UpdateDriver(driver);
        DatabaseOperation.session.commit();
    }

    public static boolean oldPasswordIsRight(String ID, String oldPassword) throws Exception {
        return DriverLogin.verifyPassword(ID, oldPassword);
    }

    public static boolean checkPassword(String password) {
        return DriverRegister.checkPassword(password);
    }

    public static void updateDriverNewPassword(String ID, String newPassword) {
        DriverMapper driverMapper = DatabaseOperation.session.getMapper(DriverMapper.class);
        driverMapper.UpdatePassword(ID, newPassword);
        DatabaseOperation.session.commit();
    }
}

package SmartBusSystem.service.function;

import SmartBusSystem.dao.DriverDao;
import SmartBusSystem.dao.impl.DriverDaoImpl;
import SmartBusSystem.pojo.Driver;
import SmartBusSystem.service.tool.SecurityProtect;

public class DriverInformationModify {
    private static final DriverDao driverDao = new DriverDaoImpl();

    public static boolean checkPhoneNum(String phoneNum) {
        return phoneNum.matches("1\\d{10}");
    }

    public static void updateDriverInformation(Driver driver) {
        driverDao.UpdateDriver(driver);
    }

    public static boolean oldPasswordIsRight(String ID, String oldPassword) throws Exception {
        Driver driver = driverDao.SelectById(ID);
        return oldPassword.equals(SecurityProtect.decrypt(driver.getPassword()));
    }

    public static boolean checkPassword(String password) {
        return password.matches("[A-Za-z0-9@#*]{6,20}");
    }

    public static void updateDriverNewPassword(String ID, String newPassword) {
        driverDao.UpdatePassword(ID, newPassword);
    }
}

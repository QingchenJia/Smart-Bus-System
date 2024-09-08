package SmartBusSystem.service.info;

import SmartBusSystem.Util.CipherUtil;
import SmartBusSystem.dao.DriverDao;
import SmartBusSystem.dao.impl.DriverDaoImpl;
import SmartBusSystem.pojo.Driver;

public class DriverInfoMdf {
    private static final DriverDao driverDao = new DriverDaoImpl();

    public boolean checkPhoneNum(String phoneNum) {
        return phoneNum.matches("1\\d{10}");
    }

    public void updateDriverInformation(Driver driver) {
        driverDao.UpdateDriver(driver);
    }

    public boolean oldPasswordIsRight(String ID, String oldPassword) throws Exception {
        Driver driver = driverDao.SelectById(ID);
        return oldPassword.equals(CipherUtil.decrypt(driver.getPassword()));
    }

    public boolean checkPassword(String password) {
        return password.matches("[A-Za-z0-9@#*]{6,20}");
    }

    public void updateDriverNewPassword(String ID, String newPassword) {
        driverDao.UpdatePassword(ID, newPassword);
    }
}

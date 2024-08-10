package SmartBusSystem.service.recover.impl;

import SmartBusSystem.dao.DriverDao;
import SmartBusSystem.dao.impl.DriverDaoImpl;
import SmartBusSystem.pojo.Driver;
import SmartBusSystem.service.recover.Recover;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DriverRecover implements Recover {
    private static final DriverDao driverDao = new DriverDaoImpl();

    @Override
    public boolean verifyID(String ID) {
        Driver driver = driverDao.SelectById(ID);
        return driver != null;
    }

    @Override
    public boolean verifyPhoneNum(String ID, String phoneNum) {
        Driver driver = driverDao.SelectById(ID);
        return phoneNum.equals(driver.getPhoneNum());
    }

    @Override
    public boolean checkPassword(String password) {
        return password.matches("[A-Za-z0-9@#*]{6,20}");
    }

    @Override
    public void resetPassword(String ID, String newPassword) {
        driverDao.UpdatePassword(ID, newPassword);
    }
}

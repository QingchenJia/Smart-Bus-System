package SmartBusSystem.service.login.impl;

import SmartBusSystem.Util.CipherUtil;
import SmartBusSystem.dao.DriverDao;
import SmartBusSystem.dao.impl.DriverDaoImpl;
import SmartBusSystem.pojo.Driver;
import SmartBusSystem.service.login.Login;

public class DriverLogin implements Login {
    private static final DriverDao driverDao = new DriverDaoImpl();

    @Override
    public boolean verifyID(String ID) {
        Driver driver = driverDao.SelectById(ID);
        return driver != null;
    }

    @Override
    public boolean verifyPassword(String ID, String password) throws Exception {
        Driver driver = driverDao.SelectById(ID);
        return password.equals(CipherUtil.decrypt(driver.getPassword()));
    }

    @Override
    public boolean verifyVerifyCode(String code, String rightCode) {
        return rightCode.equals(code);
    }
}

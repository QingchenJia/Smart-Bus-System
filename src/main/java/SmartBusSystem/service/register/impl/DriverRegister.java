package SmartBusSystem.service.register.impl;

import SmartBusSystem.dao.DriverDao;
import SmartBusSystem.dao.impl.DriverDaoImpl;
import SmartBusSystem.pojo.Driver;
import SmartBusSystem.service.register.Register;

public class DriverRegister implements Register {
    private static final DriverDao driverDao = new DriverDaoImpl();

    @Override
    public boolean containObject(String ID) {
        Driver driver = driverDao.SelectById(ID);
        return driver != null;
    }

    @Override
    public boolean checkID(String ID) {
        return ID.matches("[A-Za-z0-9]{6,10}");
    }

    @Override
    public boolean checkPassword(String password) {
        return password.matches("[A-Za-z0-9@#*]{6,20}");
    }

    @Override
    public boolean checkPhoneNum(String phoneNum) {
        return phoneNum.matches("1\\d{10}");
    }

    @Override
    public void register(Object object) {
        driverDao.InsertDriver((Driver) object);
    }
}

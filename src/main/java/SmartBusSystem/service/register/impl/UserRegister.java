package SmartBusSystem.service.register.impl;

import SmartBusSystem.dao.UserDao;
import SmartBusSystem.dao.impl.UserDaoImpl;
import SmartBusSystem.pojo.User;
import SmartBusSystem.service.register.Register;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserRegister implements Register {
    private static final UserDao userDao = new UserDaoImpl();

    @Override
    public boolean containObject(String ID) {
        User user = userDao.SelectById(ID);
        return user != null;
    }

    @Override
    public boolean checkID(String ID) {
        return ID.matches("[A-Za-z0-9]{6,10}");
    }

    @Override
    public boolean checkPassword(String password) {
        return password.matches("[A-Za-z0-9@#.]{6,20}");
    }

    @Override
    public boolean checkPhoneNum(String phoneNum) {
        return phoneNum.matches("[1]\\d{10}");
    }

    @Override
    public void register(Object object) {
        userDao.InsertUser((User) object);
    }
}

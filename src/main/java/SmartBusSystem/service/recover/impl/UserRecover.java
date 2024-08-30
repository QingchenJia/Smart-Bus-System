package SmartBusSystem.service.recover.impl;

import SmartBusSystem.dao.UserDao;
import SmartBusSystem.dao.impl.UserDaoImpl;
import SmartBusSystem.pojo.User;
import SmartBusSystem.service.recover.Recover;

public class UserRecover implements Recover {
    private static final UserDao userDao = new UserDaoImpl();

    @Override
    public boolean verifyID(String ID) {
        User user = userDao.SelectById(ID);
        return user != null;
    }

    @Override
    public boolean verifyPhoneNum(String ID, String phoneNum) {
        User user = userDao.SelectById(ID);
        return phoneNum.equals(user.getPhoneNum());
    }

    @Override
    public boolean checkPassword(String password) {
        return password.matches("[A-Za-z0-9@#*]{6,20}");
    }

    @Override
    public void resetPassword(String ID, String newPassword) {
        userDao.UpdatePassword(ID, newPassword);
    }
}

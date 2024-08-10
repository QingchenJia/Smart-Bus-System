package SmartBusSystem.service.login.impl;

import SmartBusSystem.dao.UserDao;
import SmartBusSystem.dao.impl.UserDaoImpl;
import SmartBusSystem.pojo.User;
import SmartBusSystem.service.login.Login;
import SmartBusSystem.service.tool.SecurityProtect;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserLogin implements Login {
    private static final UserDao userDao = new UserDaoImpl();

    @Override
    public boolean verifyID(String ID) {
        User user = userDao.SelectById(ID);
        return user != null;
    }

    @Override
    public boolean verifyPassword(String ID, String password) throws Exception {
        User user = userDao.SelectById(ID);
        return password.equals(SecurityProtect.decrypt(user.getPassword()));
    }

    @Override
    public boolean verifyVerifyCode(String code, String rightCode) {
        return rightCode.equals(code);
    }
}

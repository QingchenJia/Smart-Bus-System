package SmartBusSystem.service.login.impl;

import SmartBusSystem.dao.AdminDao;
import SmartBusSystem.dao.impl.AdminDaoImpl;
import SmartBusSystem.pojo.Admin;
import SmartBusSystem.service.login.Login;
import SmartBusSystem.service.tool.SecurityProtect;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AdminLogin implements Login {
    private static final AdminDao adminDao = new AdminDaoImpl();

    @Override
    public boolean verifyID(String ID) {
        Admin admin = adminDao.SelectById(ID);
        return admin != null;
    }

    @Override
    public boolean verifyPassword(String ID, String password) throws Exception {
        Admin admin = adminDao.SelectById(ID);
        return password.equals(SecurityProtect.decrypt(admin.getPassword()));
    }

    @Override
    public boolean verifyVerifyCode(String code, String rightCode) {
        return false;
    }
}
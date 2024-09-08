package SmartBusSystem.service.info;

import SmartBusSystem.Util.CipherUtil;
import SmartBusSystem.dao.UserDao;
import SmartBusSystem.dao.impl.UserDaoImpl;
import SmartBusSystem.pojo.User;
import SmartBusSystem.service.register.impl.UserRegister;

public class UserInfoMdf {
    private static final UserDao userDao = new UserDaoImpl();

    public boolean checkPhoneNum(String phoneNum) {
        return new UserRegister().checkPhoneNum(phoneNum);
    }

    public void updateUserInformation(User user) {   // 更新用户基本信息
        userDao.UpdateUser(user);
    }

    public boolean oldPasswordIsRight(String ID, String oldPassword) throws Exception {
        User user = userDao.SelectById(ID);
        return oldPassword.equals(CipherUtil.decrypt(user.getPassword()));
    }

    public boolean checkPassword(String password) {
        return password.matches("[A-Za-z0-9@#.]{6,20}");
    }

    public void updateUserNewPassword(String ID, String newPassword) {   // 修改密码
        userDao.UpdatePassword(ID, newPassword);
    }
}

package SmartBusSystem.service.function;

import SmartBusSystem.dao.UserDao;
import SmartBusSystem.dao.impl.UserDaoImpl;
import SmartBusSystem.pojo.User;
import SmartBusSystem.service.register.impl.UserRegister;
import SmartBusSystem.service.tool.SecurityProtect;

public class UserInformationModify {
    private static final UserDao userDao = new UserDaoImpl();

    public static boolean checkPhoneNum(String phoneNum) {
        return new UserRegister().checkPhoneNum(phoneNum);
    }

    public static void updateUserInformation(User user) {   // 更新用户基本信息
        userDao.UpdateUser(user);
    }

    public static boolean oldPasswordIsRight(String ID, String oldPassword) throws Exception {
        User user = userDao.SelectById(ID);
        return oldPassword.equals(SecurityProtect.decrypt(user.getPassword()));
    }

    public static boolean checkPassword(String password) {
        return password.matches("[A-Za-z0-9@#.]{6,20}");
    }

    public static void updateUserNewPassword(String ID, String newPassword) {   // 修改密码
        userDao.UpdatePassword(ID, newPassword);
    }
}

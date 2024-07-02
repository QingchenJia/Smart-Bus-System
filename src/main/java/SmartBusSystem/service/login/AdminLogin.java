package SmartBusSystem.service.login;

import SmartBusSystem.mapper.AdminMapper;
import SmartBusSystem.pojo.Admin;
import SmartBusSystem.service.DatabaseOperation;
import SmartBusSystem.service.SecurityProtect;

public class AdminLogin {
    public static boolean verifyID(String ID) {
        AdminMapper adminMapper = DatabaseOperation.session.getMapper(AdminMapper.class);
        Admin admin = adminMapper.SelectById(ID);
        System.out.println(admin);  // 控制台展示查询结果
        return admin != null;
    }

    public static boolean verifyPassword(String ID, String password) throws Exception {
        AdminMapper adminMapper = DatabaseOperation.session.getMapper(AdminMapper.class);
        Admin admin = adminMapper.SelectById(ID);
        System.out.println(admin);  // 控制台展示查询结果
        return password.equals(SecurityProtect.decrypt(admin.getPassword()));
    }
}

package SmartBusSystem.service.register;

import SmartBusSystem.mapper.DriverMapper;
import SmartBusSystem.pojo.Driver;
import SmartBusSystem.service.DatabaseOperation;

public class DriverRegister {
    public static boolean containDriver(String ID) {
        DriverMapper driverMapper = DatabaseOperation.session.getMapper(DriverMapper.class);
        Driver driver = driverMapper.SelectById(ID);
        System.out.println(driver); // 控制台展示查询结果
        return driver != null;
    }

    public static boolean checkID(String ID) {
        return ID.matches("[A-Za-z0-9]{6,10}");
    }

    public static boolean checkPassword(String password) {
        return password.matches("[A-Za-z0-9@#*]{6,20}");
    }

    public static boolean checkPhoneNum(String phoneNum) {
        return UserRegister.checkPhoneNum(phoneNum);
    }

    public static void register(Driver driver) {
        DriverMapper driverMapper = DatabaseOperation.session.getMapper(DriverMapper.class);
        driverMapper.InsertDriver(driver);
        DatabaseOperation.session.commit();
    }
}

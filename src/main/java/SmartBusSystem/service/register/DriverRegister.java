package SmartBusSystem.service.register;

import SmartBusSystem.mapper.DriverMapper;
import SmartBusSystem.pojo.Driver;
import SmartBusSystem.service.tool.DatabaseOperation;
import org.apache.ibatis.session.SqlSession;

public class DriverRegister {
    private static final SqlSession sqlSession;
    private static final DriverMapper driverMapper;

    static {
        sqlSession = DatabaseOperation.getSqlSession();
        driverMapper = sqlSession.getMapper(DriverMapper.class);
    }

    public static boolean containDriver(String ID) {
        DriverMapper driverMapper = sqlSession.getMapper(DriverMapper.class);
        Driver driver = driverMapper.SelectById(ID);
        System.out.println("检索司机->" + driver);  // 控制台展示查询结果
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
        driverMapper.InsertDriver(driver);
        sqlSession.commit();
    }
}

package SmartBusSystem.service.register.impl;

import SmartBusSystem.mapper.DriverMapper;
import SmartBusSystem.pojo.Driver;
import SmartBusSystem.service.register.Register;
import SmartBusSystem.service.tool.DatabaseOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;

@Slf4j
public class DriverRegister implements Register {
    private static final SqlSession sqlSession;
    private static final DriverMapper driverMapper;

    static {
        sqlSession = DatabaseOperation.getSqlSession();
        driverMapper = sqlSession.getMapper(DriverMapper.class);
    }

    @Override
    public boolean containObject(String ID) {
        Driver driver = driverMapper.SelectById(ID);
        log.info("检索司机->" + driver);  // 控制台展示查询结果
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
        return phoneNum.matches("[1]\\d{10}");
    }

    @Override
    public void register(Object object) {
        driverMapper.InsertDriver((Driver) object);
        sqlSession.commit();
    }

    public static void register(Driver driver) {

    }
}

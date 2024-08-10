package SmartBusSystem.dao.impl;

import SmartBusSystem.dao.DriverDao;
import SmartBusSystem.mapper.DriverMapper;
import SmartBusSystem.pojo.Driver;
import SmartBusSystem.service.tool.DatabaseOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

@Slf4j
public class DriverDaoImpl implements DriverDao {
    private static final SqlSession sqlSession;
    private static final DriverMapper driverMapper;

    static {
        sqlSession = DatabaseOperation.getSqlSession();
        driverMapper = sqlSession.getMapper(DriverMapper.class);
    }

    @Override
    public List<Driver> SelectAll() {
        List<Driver> drivers = driverMapper.SelectAll();
        log.info("全部司机->" + drivers);
        return drivers;
    }

    @Override
    public Driver SelectById(String ID) {
        Driver driver = driverMapper.SelectById(ID);
        log.info("当前司机->" + driver);
        return driver;
    }

    @Override
    public List<Driver> SelectDriverAvailable(String time) {
        List<Driver> drivers = driverMapper.SelectDriverAvailable(time);
        log.info("可用司机->" + drivers);
        return drivers;
    }

    @Override
    public List<Driver> SelectDriverIsArranged(String time) {
        List<Driver> drivers = driverMapper.SelectDriverIsArranged(time);
        log.info("在班司机->" + drivers);
        return drivers;
    }

    @Override
    public void InsertDriver(Driver driver) {
        driverMapper.InsertDriver(driver);
        sqlSession.commit();
    }

    @Override
    public void UpdateDriver(Driver driver) {
        driverMapper.UpdateDriver(driver);
        sqlSession.commit();
    }

    @Override
    public void UpdatePassword(String ID, String password) {
        driverMapper.UpdatePassword(ID, password);
        sqlSession.commit();
    }
}

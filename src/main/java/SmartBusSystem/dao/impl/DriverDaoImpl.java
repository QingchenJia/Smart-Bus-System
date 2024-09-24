package SmartBusSystem.dao.impl;

import SmartBusSystem.dao.DriverDao;
import SmartBusSystem.mapper.DriverMapper;
import SmartBusSystem.pojo.Driver;
import SmartBusSystem.Util.DatabaseUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class DriverDaoImpl implements DriverDao {
    private static final SqlSession sqlSession;
    private static final DriverMapper driverMapper;

    static {
        sqlSession = DatabaseUtil.getSqlSession();
        driverMapper = sqlSession.getMapper(DriverMapper.class);
    }

    @Override
    public List<Driver> SelectAll() {
        return driverMapper.SelectAll();
    }

    @Override
    public Driver SelectById(String ID) {
        return driverMapper.SelectById(ID);
    }

    @Override
    public List<Driver> SelectDriverAvailable(String time) {
        return driverMapper.SelectDriverAvailable(time);
    }

    @Override
    public List<Driver> SelectDriverIsArranged(String time) {
        return driverMapper.SelectDriverIsArranged(time);
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

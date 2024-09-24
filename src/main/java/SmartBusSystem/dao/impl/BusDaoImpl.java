package SmartBusSystem.dao.impl;

import SmartBusSystem.dao.BusDao;
import SmartBusSystem.mapper.BusMapper;
import SmartBusSystem.pojo.Bus;
import SmartBusSystem.Util.DatabaseUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class BusDaoImpl implements BusDao {
    private static final SqlSession sqlSession;
    private static final BusMapper busMapper;

    static {
        sqlSession = DatabaseUtil.getSqlSession();
        busMapper = sqlSession.getMapper(BusMapper.class);
    }

    @Override
    public List<Bus> SelectAll() {
        return busMapper.SelectAll();
    }

    @Override
    public Bus SelectByLicenseNumber(String licenseNumber) {
        return busMapper.SelectByLicenseNumber(licenseNumber);
    }

    @Override
    public List<Bus> SelectBusAvailable(String dayOfWeek) {
        return busMapper.SelectBusAvailable(dayOfWeek);
    }

    @Override
    public void InsertBus(Bus bus) {
        busMapper.InsertBus(bus);
        sqlSession.commit();
    }

    @Override
    public void UpdateBusStatus(Bus bus) {
        busMapper.UpdateBusStatus(bus);
        sqlSession.commit();
    }

    @Override
    public void DeleteBus(String licenseNumber) {
        busMapper.DeleteBus(licenseNumber);
        sqlSession.commit();
    }
}

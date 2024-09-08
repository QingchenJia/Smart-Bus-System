package SmartBusSystem.dao.impl;

import SmartBusSystem.dao.BusDao;
import SmartBusSystem.mapper.BusMapper;
import SmartBusSystem.pojo.Bus;
import SmartBusSystem.Util.DatabaseUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

@Slf4j
public class BusDaoImpl implements BusDao {
    private static final SqlSession sqlSession;
    private static final BusMapper busMapper;

    static {
        sqlSession = DatabaseUtil.getSqlSession();
        busMapper = sqlSession.getMapper(BusMapper.class);
    }

    @Override
    public List<Bus> SelectAll() {
        List<Bus> buses = busMapper.SelectAll();
        log.info("全部车辆->" + buses);
        return buses;
    }

    @Override
    public Bus SelectByLicenseNumber(String licenseNumber) {
        Bus bus = busMapper.SelectByLicenseNumber(licenseNumber);
        log.info("检索车辆->" + bus);
        return bus;
    }

    @Override
    public List<Bus> SelectBusAvailable(String dayOfWeek) {
        List<Bus> buses = busMapper.SelectBusAvailable(dayOfWeek);
        log.info("可用车辆->" + buses);
        return buses;
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

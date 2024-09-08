package SmartBusSystem.dao.impl;

import SmartBusSystem.dao.AdminDao;
import SmartBusSystem.mapper.AdminMapper;
import SmartBusSystem.pojo.Admin;
import SmartBusSystem.Util.DatabaseUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;

@Slf4j
public class AdminDaoImpl implements AdminDao {
    private static final SqlSession sqlSession;
    private static final AdminMapper adminMapper;

    static {
        sqlSession = DatabaseUtil.getSqlSession();
        adminMapper = sqlSession.getMapper(AdminMapper.class);
    }

    @Override
    public Admin SelectById(String ID) {
        Admin admin = adminMapper.SelectById(ID);
        log.info("检索管理员->" + admin);  // 控制台展示查询结果
        return admin;
    }
}

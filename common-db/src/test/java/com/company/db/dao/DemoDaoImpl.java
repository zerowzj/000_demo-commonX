package com.company.db.dao;

import com.company.db.datasource.DataSourceHolder;
import com.company.db.datasource.DataSourceType;
import org.springframework.stereotype.Repository;

/**
 * <p></p>
 *
 * @author wangzhj
 * @time 2016-11-25 18:18
 */
@Repository("demoDao")
public class DemoDaoImpl extends BaseDaoImpl<DemoEO> implements DemoDao {

    @Override
    public DemoEO findLt(Long id) {
        DataSourceHolder.put(DataSourceType.READ);
        String sqlId = getSqlId("get");
        DemoEO entity = sqlSessionTemplate.selectOne(sqlId, id);
        return entity;
    }
}

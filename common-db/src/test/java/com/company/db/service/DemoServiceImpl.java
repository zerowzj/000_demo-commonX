package com.company.db.service;


import com.company.db.dao.DemoDao;
import com.company.db.dao.DemoEO;
import com.company.db.datasource.DataSourceHolder;
import com.company.db.datasource.DataSourceType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.Map;

/**
 * <p></p>
 *
 * @author wangzhj
 * @time 2016-12-01 11:23
 */
@Service("demoService")
public class DemoServiceImpl implements DemoService {

    private static final Logger logger = LoggerFactory.getLogger(DemoServiceImpl.class);

    @Autowired
    private DemoDao demoDao = null;

    @Override
    public void add(String name) {
        DemoEO demoEO = new DemoEO();
        demoEO.setName(name);
        demoDao.insert(demoEO);
    }

    @Override
    public void get(Long id) {
        DemoEO demoEO = demoDao.get(id);
        logger.info(demoEO.getName());
    }

    @Override
    public void find(Long id) {
        DemoEO demoEO = demoDao.get(id);
        logger.info(demoEO.getName());
    }

    @Override
    public void findLt(Long id, boolean f) {
        Map m = TransactionSynchronizationManager.getResourceMap();
       String str = TransactionSynchronizationManager.getCurrentTransactionName();
        TransactionSynchronizationManager.getSynchronizations();
        DemoEO demoEO = demoDao.findLt(id);
        logger.info(demoEO.getName());
    }
}

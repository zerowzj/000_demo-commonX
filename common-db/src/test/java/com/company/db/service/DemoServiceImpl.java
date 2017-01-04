package com.company.db.service;


import com.company.db.dao.DemoDao;
import com.company.db.dao.DemoEO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p></p>
 *
 * @author wangzhj
 * @time 2016-12-01 11:23
 */
@Service("demoService")
public class DemoServiceImpl implements DemoService {

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
        System.out.println(demoEO.getName());
    }

    @Override
    public void find(Long id) {
        DemoEO demoEO = demoDao.get(id);
        System.out.println(demoEO.getName());
    }
}

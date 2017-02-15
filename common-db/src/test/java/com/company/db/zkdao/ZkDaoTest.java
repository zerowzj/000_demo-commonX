package com.company.db.zkdao;


import com.company.db.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author wangzhj
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-zkdao.xml"})
public class ZkDaoTest {

    private static final Logger logger = LoggerFactory.getLogger(ZkDaoTest.class);

    @Autowired
    private NodeDao nodeDao;

    @Test
    public void test() {
        List<NodeEO> nodeLt = nodeDao.getChildrenNodeData("/xdfapp/teacher-web/v1.6/unchange");
        for (NodeEO nodeEO : nodeLt) {
            logger.info("{}=={}", nodeEO.getNodeName(), nodeEO.getNodeData());
        }

        List<NodeEO> nodeLt2 = nodeDao.getChildrenNodeData("/xdfapp/teacher-web/v1.6/unchange");
        for (NodeEO nodeEO : nodeLt) {
            logger.info("{}=={}", nodeEO.getNodeName(), nodeEO.getNodeData());
        }
    }
}

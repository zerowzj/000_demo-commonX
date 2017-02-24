package com.company.client.zk;

import com.company.client.zk.dao.NodeDao;
import com.company.client.zk.dao.NodeEO;
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
public class NodeDaoTest {

    private static final Logger logger = LoggerFactory.getLogger(NodeDaoTest.class);

    @Autowired
    private NodeDao nodeDao;

    @Autowired
    private NodeDao nodeDao2;

    @Test
    public void test() {
        List<NodeEO> nodeLt = nodeDao.getChildrenNodeData("/xdfapp/teacher-web/v1.6/unchange");
        logger.info("===>");
        for (NodeEO nodeEO : nodeLt) {
            logger.info("{} = {}", nodeEO.getNodeName(), nodeEO.getNodeData());
        }
        logger.info("===>");
    }

    @Test
    public void test_() {
        List<String> nodeLt = nodeDao.getChildrenNode("/xdfapp/teacher-web/v1.6/unchange");
        logger.info("===>");
        for (String nodeName : nodeLt) {
            logger.info("{}", nodeName);
        }
        logger.info("===>");

        List<String> node2Lt = nodeDao2.getChildrenNode("/xdfapp/teacher-web/v1.6/unchange");
        logger.info("===>");
        for (String nodeName : node2Lt) {
            logger.info("{}", nodeName);
        }
        logger.info("===>");
    }
}

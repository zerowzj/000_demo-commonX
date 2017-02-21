package com.company.zk.dao;

import com.google.common.base.Charsets;
import com.google.common.base.Objects;
import com.google.common.base.Throwables;
import com.google.common.collect.Lists;
import org.apache.curator.framework.api.*;
import org.apache.curator.utils.ZKPaths;
import org.apache.zookeeper.data.Stat;

import java.util.List;

public class NodeDaoImpl extends BaseDaoImpl implements NodeDao {

    @Override
    public boolean createNode(String nodeName) {
        return createNode(nodeName, "");
    }

    @Override
    public boolean createNode(String nodeName, String value) {
        boolean suc = false;
        try {
            Stat stat = getClient().checkExists().forPath(nodeName);
            if (stat == null) {
                CreateBuilder createBuilder = getClient().create();
                String opResult = createBuilder.creatingParentsIfNeeded().forPath(nodeName, value.getBytes("UTF-8"));
                suc = Objects.equal(nodeName, opResult);
            }
        } catch (Exception ex) {
            Throwables.throwIfUnchecked(ex);
        }
        return suc;
    }

    @Override
    public boolean updateNode(String nodeName, String value) {
        boolean suc = false;
        try {
            Stat stat = getClient().checkExists().forPath(nodeName);
            if (stat != null) {
                SetDataBuilder setDataBuilder = getClient().setData();
                Stat opResult = setDataBuilder.forPath(nodeName, value.getBytes("UTF-8"));
                suc = opResult != null;
            } else {
                createNode(nodeName, value);
            }
        } catch (Exception ex) {
            Throwables.throwIfUnchecked(ex);
        }
        return suc;
    }

    @Override
    public void deleteNode(String nodeName) {
        try {
            Stat stat = getClient().checkExists().forPath(nodeName);
            if (stat != null) {
                DeleteBuilder deleteBuilder = getClient().delete();
                deleteBuilder.deletingChildrenIfNeeded().forPath(nodeName);
            }
        } catch (Exception ex) {
            Throwables.throwIfUnchecked(ex);
        }
    }

    @Override
    public NodeEO getNodeData(String nodeName) {
        try {
            Stat stat = getClient().checkExists().forPath(nodeName);
            if (stat != null) {

            }
        } catch (Exception ex) {

        }
        return null;
    }

    @Override
    public List<String> getChildrenNode(String nodeName) {
        List<String> children = null;
        try {
            Stat stat = getClient().checkExists().forPath(nodeName);
            if (stat != null) {
                GetChildrenBuilder childrenBuilder = getClient().getChildren();
                children = childrenBuilder.forPath(nodeName);
            }
        } catch (Exception ex) {
            Throwables.throwIfUnchecked(ex);
        }
        return children;
    }

    @Override
    public List<NodeEO> getChildrenNodeData(String nodeName) {
        List<NodeEO> nodeEOLt = Lists.newArrayList();
        try {
            Stat stat = getClient().checkExists().forPath(nodeName);
            if (stat != null) {
                GetChildrenBuilder getChildrenBuilder = getClient().getChildren();
                GetDataBuilder getDataBuilder = getClient().getData();
                List<String> children = getChildrenBuilder.forPath(nodeName);
                if (children != null) {
                    for (String child : children) {
                        String propPath = ZKPaths.makePath(nodeName, child);

                        NodeEO nodeEO = new NodeEO();
                        nodeEO.setNodeName(propPath);
                        nodeEO.setNodeData(new String(getDataBuilder.forPath(propPath), Charsets.UTF_8));

                        nodeEOLt.add(nodeEO);
                    }
                }
            }
        } catch (Exception ex) {
            Throwables.throwIfUnchecked(ex);
        }
        return nodeEOLt;
    }
}

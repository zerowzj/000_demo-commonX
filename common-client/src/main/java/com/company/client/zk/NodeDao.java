package com.company.client.zk;

import java.util.List;

/**
 * 节点Dao
 *
 * @author wangzhj
 */
public interface NodeDao {

    /**
     * 新增节点
     *
     * @param nodeName
     * @return boolean
     */
    public boolean createNode(String nodeName);

    /**
     * 新增节点
     *
     * @param nodeName
     * @param value
     * @return boolean
     */
    public boolean createNode(String nodeName, String value);

    /**
     * 更新节点
     *
     * @param nodeName
     * @param value
     * @return boolean
     */
    public boolean updateNode(String nodeName, String value);

    /**
     * 删除节点
     *
     * @param nodeName
     * @return boolean
     */
    public void deleteNode(String nodeName);

    /**
     * 获取节点数据
     *
     * @param nodeName
     * @return NodeEO
     */
    public NodeEO getNodeData(String nodeName);

    /**
     * 获取子节点
     *
     * @param nodeName
     * @return List<String>
     */
    public List<String> getChildrenNode(String nodeName);

    /**
     * 获取子节点数据
     *
     * @param nodeName
     * @return List<NodeEO>
     */
    public List<NodeEO> getChildrenNodeData(String nodeName);
}

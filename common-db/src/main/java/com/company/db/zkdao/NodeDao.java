package com.company.db.zkdao;

import java.util.List;

/**
 * <p>节点Dao</p>
 *
 * @author wangzhj
 * @time 2016-11-21 9:44
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

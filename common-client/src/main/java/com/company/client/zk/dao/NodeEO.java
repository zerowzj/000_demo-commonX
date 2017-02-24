package com.company.client.zk.dao;

import com.google.common.base.Joiner;

import java.io.Serializable;

/**
 * 节点实体
 *
 * @author wangzhj
 */
public class NodeEO implements Serializable {

    /** 节点名称 */
    private String nodeName = null;
    /** 节点数据 */
    private String nodeData = null;

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getNodeData() {
        return nodeData;
    }

    public void setNodeData(String nodeData) {
        this.nodeData = nodeData;
    }

    @Override
    public String toString() {
        return Joiner.on(", ").join(nodeName, nodeData);
    }
}

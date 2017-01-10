package com.company.db.dao;

/**
 * <p></p>
 *
 * @author wangzhj
 * @time 2016-11-25 18:40
 */
public class OrderEO extends BaseEO {

    private Long id = null;

    private String name = null;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

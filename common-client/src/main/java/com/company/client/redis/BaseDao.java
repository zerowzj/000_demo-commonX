package com.company.client.redis;

/**
 * Created by wangzhj on 2017/2/24.
 */
interface BaseDao {

    public boolean set(String key, String value);

    public boolean set(String key, String value, long ex);

    public boolean set(byte[] key, byte[] value);

    public boolean set(byte[] key, byte[] value, long ex);
}

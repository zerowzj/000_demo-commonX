package com.company.db;

import com.dangdang.ddframe.rdb.sharding.api.ShardingValue;
import com.dangdang.ddframe.rdb.sharding.api.strategy.table.SingleKeyTableShardingAlgorithm;

import java.util.Collection;

public final class ShardingAlgorithm implements SingleKeyTableShardingAlgorithm<Long> {

    @Override
    public String doEqualSharding(Collection<String> availableTargetNames, ShardingValue<Long> shardingValue) {
        for (String each : availableTargetNames) {
            String end = "_" + (shardingValue.getValue() % 3);
            if (each.endsWith(end)) {
                return each;
            }
        }
        throw new UnsupportedOperationException();
    }

    @Override
    public Collection<String> doInSharding(Collection collection, ShardingValue shardingValue) {
        return null;
    }

    @Override
    public Collection<String> doBetweenSharding(Collection collection, ShardingValue shardingValue) {
        return null;
    }
}

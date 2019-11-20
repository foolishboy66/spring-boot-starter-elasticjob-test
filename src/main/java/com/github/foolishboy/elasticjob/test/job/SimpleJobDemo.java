package com.github.foolishboy.elasticjob.test.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.github.foolishboy.elasticjob.annotation.ElasticJobScheduled;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * test
 *
 * @author wangjinbo[wangjinbo.six@bytedance.com]
 * @date 2019-11-20 15:47
 */
@Slf4j
@Component
@ElasticJobScheduled(jobName = "${simple.job.demo.job.jobName}", corn = "${simple.job.demo.job.cron}", shardingTotalCount = "${simple.job.demo.job.shardingTotalCount}")
public class SimpleJobDemo implements SimpleJob {

    @Override
    public void execute(ShardingContext shardingContext) {

        log.info("当前分片项 shardingItem={}, jobName={}", shardingContext.getShardingItem(), shardingContext.getJobName());
        // do something...
    }
}
package com.andaily.service.operation.job;

import com.andaily.domain.shared.BeanProvider;
import com.andaily.service.LogService;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 2017/1/21
 * <p/>
 * <p/>
 * 自动清理 监控日志 的定时任务
 *
 * @author Shengzhao Li
 */
@DisallowConcurrentExecution
public class AutoMonitorLogJob implements Job {

    private static final Logger LOG = LoggerFactory.getLogger(AutoMonitorLogJob.class);

    private transient LogService logService = BeanProvider.getBean(LogService.class);


    public AutoMonitorLogJob() {
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        final JobKey key = context.getJobDetail().getKey();
        LOG.debug("*****  Start execute Job [{}]", key);

        logService.executeAutoCleanMonitorLogs();

        LOG.debug("&&&&&  End execute Job [{}]", key);
    }
}

package com.andaily.domain.log.reminder;

import com.andaily.domain.log.FrequencyMonitorLog;
import com.andaily.domain.log.LogRepository;
import com.andaily.domain.shared.BeanProvider;

import java.util.List;

/**
 * @author Shengzhao Li
 */
public class PerMonitoringReminderChecker {

    private transient LogRepository logRepository = BeanProvider.getBean(LogRepository.class);
    private final FrequencyMonitorLog monitorLog;

    public PerMonitoringReminderChecker(FrequencyMonitorLog monitorLog) {
        this.monitorLog = monitorLog;
    }


    /**
     * 判断是否需要发送提醒
     *
     * @return True is need, otherwise not need
     */
    public boolean isNeedReminder() {

        if (monitorLog.normal()) {
            return changeNormalNeedReminder();
        } else {
            return changeNotNormalNeedReminder();
        }

    }


    /*
    * 若是变为不正常, 则需要根据 Instance 设置来判断是否发送
    * */
    private boolean changeNotNormalNeedReminder() {

        //查询设置的最近几条监控记录
        final int continueFailedTimes = monitorLog.instance().continueFailedTimes();
        List<FrequencyMonitorLog> lastLogs = getLastLogsByCurrentLogs(continueFailedTimes);

        /*
        * 若无历史日志, 则只有 continueFailedTimes == 1 时需要发送提醒
        * */
        if (lastLogs.isEmpty()) {
            return continueFailedTimes == 1;
        }

        int failedTimes = 0;
        for (FrequencyMonitorLog log : lastLogs) {
            //只要有一条是正常则不需要发送
            if (log.normal()) {
                return failedTimes + 1 == continueFailedTimes;
            } else {
                failedTimes++;
            }
        }
        // 若已连续不正常, 也不用发送
        return failedTimes != continueFailedTimes;
    }

    /*
    * 按指定的数量查找最近的监控日志
    * */
    protected List<FrequencyMonitorLog> getLastLogsByCurrentLogs(int continueFailedTimes) {
        return logRepository.findLastLogsByCurrentLog(monitorLog, continueFailedTimes);
    }

    /*
    * 若是变为正常,也需要根据 Instance 设置来判断是否发送
    * */
    private boolean changeNormalNeedReminder() {

        //查询设置的最近几条监控记录
        final int continueFailedTimes = monitorLog.instance().continueFailedTimes();
        List<FrequencyMonitorLog> lastLogs = getLastLogsByCurrentLogs(continueFailedTimes);

       /*
        * 若无历史日志, 不发送提醒
        * */
        if (lastLogs.isEmpty()) {
            return false;
        }

        int failedTimes = 0;
        for (FrequencyMonitorLog log : lastLogs) {
            //只要有一条是正常则不需要发送
            if (log.normal()) {
                return false;
            } else {
                failedTimes++;
            }
        }
        // 若已连续不正常, 要发送
        return failedTimes == continueFailedTimes;
    }


}
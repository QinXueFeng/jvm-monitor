package com.andaily.domain.user;

import com.andaily.domain.AbstractDomain;
import com.andaily.domain.shared.Application;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 15-4-14
 * <p/>
 * A global system setting,
 * it is singleton.
 *
 * @author Shengzhao Li
 */
@Entity
@Table(name = "system_setting")
public class SystemSetting extends AbstractDomain {

    private static final long serialVersionUID = 8524698169197431812L;
    /**
     * Allow register or not. default is true(allow).
     * <p/>
     * A default register user have privileges as below:
     * DEFAULT,CREATE_EDIT_INSTANCE,DELETE_INSTANCE,START_STOP_INSTANCE
     * see {@link com.andaily.domain.user.Privilege#registeredUserPrivileges()}
     */
    @Column(name = "allow_user_register", columnDefinition = "tinyint(1)")
    private boolean allowUserRegister = true;

    /**
     * 设置自动清理 监控日志的频率
     * 清理由后台自动完成
     * 清理的日志包括 {@link com.andaily.domain.log.FrequencyMonitorLog} 与 {@link com.andaily.domain.log.MonitoringReminderLog }
     */
    @Column(name = "clean_monitor_log_frequency")
    private int cleanMonitorLogFrequency = Application.CLEAN_MONITOR_LOG_FREQUENCY;


    public SystemSetting() {
    }


    public int cleanMonitorLogFrequency() {
        return cleanMonitorLogFrequency;
    }

    public SystemSetting cleanMonitorLogFrequency(int cleanMonitorLogFrequency) {
        this.cleanMonitorLogFrequency = cleanMonitorLogFrequency;
        return this;
    }

    public boolean allowUserRegister() {
        return allowUserRegister;
    }

    public SystemSetting allowUserRegister(boolean allowUserRegister) {
        this.allowUserRegister = allowUserRegister;
        return this;
    }
}

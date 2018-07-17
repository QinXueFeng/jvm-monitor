package com.andaily.domain.dto.user;

import com.andaily.domain.dto.AbstractDto;
import com.andaily.domain.user.SystemSetting;

/**
 * 15-4-14
 *
 * @author Shengzhao Li
 */
public class SystemSettingDto extends AbstractDto {

    private static final long serialVersionUID = 2289700406929530627L;


    private boolean allowUserRegister;

    private int cleanMonitorLogFrequency;

    private long monitorLogAmount;

    public SystemSettingDto() {
    }

    public SystemSettingDto(SystemSetting setting) {
        super(setting.guid());
        this.allowUserRegister = setting.allowUserRegister();
        this.cleanMonitorLogFrequency = setting.cleanMonitorLogFrequency();
    }


    public int getCleanMonitorLogFrequency() {
        return cleanMonitorLogFrequency;
    }

    public void setCleanMonitorLogFrequency(int cleanMonitorLogFrequency) {
        this.cleanMonitorLogFrequency = cleanMonitorLogFrequency;
    }

    public boolean isAllowUserRegister() {
        return allowUserRegister;
    }

    public void setAllowUserRegister(boolean allowUserRegister) {
        this.allowUserRegister = allowUserRegister;
    }

    public long getMonitorLogAmount() {
        return monitorLogAmount;
    }

    public void setMonitorLogAmount(long monitorLogAmount) {
        this.monitorLogAmount = monitorLogAmount;
    }
}

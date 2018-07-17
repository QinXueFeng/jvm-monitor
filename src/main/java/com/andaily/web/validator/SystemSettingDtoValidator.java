package com.andaily.web.validator;

import com.andaily.domain.dto.user.SystemSettingDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * 2017/1/21
 *
 * @author Shengzhao Li
 */
@Component
public class SystemSettingDtoValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return SystemSettingDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        SystemSettingDto formDto = (SystemSettingDto) target;

        final int cleanMonitorLogFrequency = formDto.getCleanMonitorLogFrequency();
        if (cleanMonitorLogFrequency < 1) {
            errors.rejectValue("cleanMonitorLogFrequency", null, "自动清理监控日志频率必须大于0");
        }

    }
}

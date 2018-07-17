package com.andaily.service.impl;

import com.andaily.domain.dto.application.ApplicationInstanceFormDto;
import com.andaily.domain.dto.application.ApplicationInstanceListDto;
import com.andaily.domain.dto.application.InstanceStatisticsDto;
import com.andaily.service.ApplicationInstanceService;
import com.andaily.service.operation.instance.*;
import com.andaily.service.operation.job.PerHeartBeatExecutor;
import org.springframework.stereotype.Service;

/**
 * 15-1-3
 *
 * @author Shengzhao Li
 */
@Service("applicationInstanceService")
public class ApplicationInstanceServiceImpl implements ApplicationInstanceService {



    @Override
    public void loadApplicationInstanceListDto(ApplicationInstanceListDto listDto) {
        ApplicationInstanceListDtoLoader dtoLoader = new ApplicationInstanceListDtoLoader(listDto);
        dtoLoader.load();
    }

    @Override
    public ApplicationInstanceFormDto loadApplicationInstanceFormDto(String guid) {
        ApplicationInstanceFormDtoLoader dtoLoader = new ApplicationInstanceFormDtoLoader(guid);
        return dtoLoader.load();
    }

    @Override
    public void persistApplicationInstance(ApplicationInstanceFormDto formDto) {
        ApplicationInstanceFormDtoPersister persister = new ApplicationInstanceFormDtoPersister(formDto);
        persister.persist();
    }

    @Override
    public boolean enableApplicationInstance(String guid) {
        ApplicationInstanceEnabler instanceEnabler = new ApplicationInstanceEnabler(guid);
        return instanceEnabler.enable();
    }

    @Override
    public void executePerHeartBeatByInstanceGuid(String instanceGuid) {
        PerHeartBeatExecutor perHeartBeatExecutor = new PerHeartBeatExecutor(instanceGuid);
        perHeartBeatExecutor.execute();
    }

    @Override
    public boolean stopMonitoringApplicationInstance(String guid) {
        MonitoringApplicationInstanceKiller instanceKiller = new MonitoringApplicationInstanceKiller(guid);
        return instanceKiller.kill();
    }

    @Override
    public boolean deleteApplicationInstance(String guid) {
        ApplicationInstanceDeleter instanceDeleter = new ApplicationInstanceDeleter(guid);
        return instanceDeleter.delete();
    }

    @Override
    public InstanceStatisticsDto loadInstanceStatisticsDto(String guid) {
        InstanceStatisticsDtoLoader statisticsDtoLoader = new InstanceStatisticsDtoLoader(guid);
        return statisticsDtoLoader.load();
    }
}

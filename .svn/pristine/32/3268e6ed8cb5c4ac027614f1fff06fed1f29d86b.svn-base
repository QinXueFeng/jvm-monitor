package com.andaily.service.operation.instance;

import com.andaily.domain.application.ApplicationInstance;
import com.andaily.domain.application.ApplicationInstanceRepository;
import com.andaily.domain.dto.application.ApplicationInstanceDto;
import com.andaily.domain.dto.application.ApplicationInstanceListDto;
import com.andaily.domain.shared.BeanProvider;
import com.andaily.domain.shared.paginated.PaginatedLoader;

import java.util.List;
import java.util.Map;

/**
 * 2015/9/22
 *
 * @author Shengzhao Li
 */
public class ApplicationInstanceListDtoLoader {

    private transient ApplicationInstanceRepository instanceRepository = BeanProvider.getBean(ApplicationInstanceRepository.class);

    private ApplicationInstanceListDto listDto;

    public ApplicationInstanceListDtoLoader(ApplicationInstanceListDto listDto) {
        this.listDto = listDto;
    }

    public ApplicationInstanceListDto load() {

        final Map<String, Object> map = listDto.queryMap();

        listDto.load(new PaginatedLoader<ApplicationInstanceDto>() {
            @Override
            public List<ApplicationInstanceDto> loadList() {
                List<ApplicationInstance> instances = instanceRepository.findApplicationInstanceList(map);
                return ApplicationInstanceDto.toDtos(instances);
            }

            @Override
            public int loadTotalSize() {
                return instanceRepository.totalApplicationInstanceList(map);
            }
        });

        return listDto;
    }
}

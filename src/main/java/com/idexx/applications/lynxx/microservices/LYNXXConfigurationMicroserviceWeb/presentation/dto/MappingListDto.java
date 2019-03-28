package com.idexx.applications.lynxx.microservices.LYNXXConfigurationMicroserviceWeb.presentation.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fghaly
 */
public class MappingListDto {
private List<MappingDto> mappingList = new ArrayList<>();

    public void addToList(MappingDto mappingDto) {
        mappingList.add(mappingDto);
    }

    public List<MappingDto> getMappingList() {
        return mappingList;
    }
}

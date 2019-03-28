package com.idexx.applications.lynxx.microservices.LYNXXConfigurationMicroserviceWeb.presentation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.idexx.applications.lynxx.microservices.LYNXXConfigurationMicroserviceWeb.application.ConfigurationManager;
import com.idexx.applications.lynxx.microservices.LYNXXConfigurationMicroserviceWeb.domain.model.datatypes.Breed;
import com.idexx.applications.lynxx.microservices.LYNXXConfigurationMicroserviceWeb.domain.model.datatypes.Gender;
import com.idexx.applications.lynxx.microservices.LYNXXConfigurationMicroserviceWeb.domain.model.datatypes.Species;
import com.idexx.applications.lynxx.microservices.LYNXXConfigurationMicroserviceWeb.presentation.dto.MappingDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.idexx.applications.lynxx.microservices.LYNXXConfigurationMicroserviceWeb.presentation.dto.MappingListDto;

import java.util.List;

/**
 * @author fghaly
 */

@ControllerAdvice(annotations = RestController.class)
@RequestMapping("/ConfigMicroService/")
@Slf4j
public class ConfigurationRestController{

    @Autowired
    private ConfigurationManager manager;

    @GetMapping(path = "/breeds/{limsRegionId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody MappingListDto getBreedsMappingByLIMSRegionId(@PathVariable("limsRegionId") String limsRegionId){
        List<Breed> breedList = manager.retrieveBreedMappingByRegionId(limsRegionId);
        MappingListDto mappingsDto = getBreedMappingListDto(breedList);
        return mappingsDto;
    }

    @GetMapping(path = "/species/{limsRegionId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody MappingListDto getSpeciesByLIMSRegionId(@PathVariable("limsRegionId") String limsRegionId){
        List<Species> speciesList = manager.retrieveSpeciesMappingByRegionId(limsRegionId);
        MappingListDto mappingsDto = getSpeciesMappingListDto(speciesList);
        return mappingsDto;
    }

    @GetMapping(path = "/gender/{limsRegionId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody MappingListDto getGenderMappingByLIMSRegionId(@PathVariable("limsRegionId") String limsRegionId){
        List<Gender> genderList = manager.retrieveGenderMappingByRegionId(limsRegionId);
        MappingListDto mappingsDto = getGenderMappingListDto(genderList);
        return mappingsDto;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity handleInternalServerError(Exception e){
        log.error("Exception: " + e.getMessage());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private MappingListDto getBreedMappingListDto(List<Breed> breedList){
        ObjectMapper objectMapper = new ObjectMapper();
        MappingListDto mappingsDto = new MappingListDto();
        for (Breed breed : breedList) {
            mappingsDto.addToList(objectMapper.convertValue(breed, MappingDto.class));
        }
        return mappingsDto;
    }

    private MappingListDto getSpeciesMappingListDto(List<Species> speciesList){
        ObjectMapper objectMapper = new ObjectMapper();
        MappingListDto mappingsDto = new MappingListDto();
        for (Species species : speciesList) {
            mappingsDto.addToList(objectMapper.convertValue(species, MappingDto.class));
        }
        return mappingsDto;
    }

    private MappingListDto getGenderMappingListDto(List<Gender> genderList){
        ObjectMapper objectMapper = new ObjectMapper();
        MappingListDto mappingsDto = new MappingListDto();
        for (Gender gender : genderList) {
            mappingsDto.addToList(objectMapper.convertValue(gender, MappingDto.class));
        }
        return mappingsDto;
    }
}

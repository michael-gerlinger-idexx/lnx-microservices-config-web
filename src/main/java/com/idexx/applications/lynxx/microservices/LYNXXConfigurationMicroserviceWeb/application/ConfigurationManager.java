package com.idexx.applications.lynxx.microservices.LYNXXConfigurationMicroserviceWeb.application;

import com.idexx.applications.lynxx.microservices.LYNXXConfigurationMicroserviceWeb.domain.model.datatypes.Breed;
import com.idexx.applications.lynxx.microservices.LYNXXConfigurationMicroserviceWeb.domain.model.datatypes.Gender;
import com.idexx.applications.lynxx.microservices.LYNXXConfigurationMicroserviceWeb.domain.model.datatypes.Species;
import com.idexx.applications.lynxx.microservices.LYNXXConfigurationMicroserviceWeb.integration.dataservices.dao.BreedDAO;
import com.idexx.applications.lynxx.microservices.LYNXXConfigurationMicroserviceWeb.integration.dataservices.dao.GenderDAO;
import com.idexx.applications.lynxx.microservices.LYNXXConfigurationMicroserviceWeb.integration.dataservices.dao.SpeciesDAO;
import com.idexx.applications.lynxx.microservices.LYNXXConfigurationMicroserviceWeb.integration.dataservices.entities.EsubmitBreedMappingEntity;
import com.idexx.applications.lynxx.microservices.LYNXXConfigurationMicroserviceWeb.integration.dataservices.entities.EsubmitGenderMappingEntity;
import com.idexx.applications.lynxx.microservices.LYNXXConfigurationMicroserviceWeb.integration.dataservices.entities.EsubmitSpeciesMappingEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fghaly
 */

@Service
@Slf4j
public class ConfigurationManager {
    @Autowired
    private GenderDAO genderDAO;

    @Autowired
    private BreedDAO breedDAO;

    @Autowired
    private SpeciesDAO speciesDAO;

    public List<Gender> retrieveGenderMappingByRegionId(String limsRegionId) {
        List<EsubmitGenderMappingEntity> esubmitGenderMappingEntities = genderDAO.retrieveGendersListByRegionId(Integer.parseInt(limsRegionId));
        List<Gender> genderList = mapGenderEntityListToGenderTypeList(esubmitGenderMappingEntities);
        return genderList;
    }

    public List<Breed> retrieveBreedMappingByRegionId(String limsRegionId) {
        List<EsubmitBreedMappingEntity> esubmitBreedMappingEntities = breedDAO.retrieveBreedsListByRegionId(Integer.parseInt(limsRegionId));
        List<Breed> breedList = mapBreedsEntityListToBreedsTypeList(esubmitBreedMappingEntities);
        return breedList;
    }

    public List<Species> retrieveSpeciesMappingByRegionId(String limsRegionId) {
        List<EsubmitSpeciesMappingEntity> esubmitSpeciesMappingEntities = speciesDAO.retrieveSpeciesListByRegionId(Integer.parseInt(limsRegionId));
        List<Species> speciesList = mapSpeciesEntityListToSpeciesTypeList(esubmitSpeciesMappingEntities);
        return speciesList;
    }

    private List<Gender> mapGenderEntityListToGenderTypeList(List<EsubmitGenderMappingEntity> esubmitGenderMappingEntities) {
        List<Gender> genderList = new ArrayList<>();
        for(EsubmitGenderMappingEntity entity : esubmitGenderMappingEntities){
            Gender gender = new Gender();
            gender.setESubmitValue(entity.getEsubmitGenderCode());
            gender.setLimsValue(entity.getLimsGenderCode());
            genderList.add(gender);
        }
        return genderList;
    }

    private List<Breed> mapBreedsEntityListToBreedsTypeList(List<EsubmitBreedMappingEntity> esubmitBreedMappingEntities) {
        List<Breed> breedList = new ArrayList<>();
        for(EsubmitBreedMappingEntity entity : esubmitBreedMappingEntities){
            Breed breed = new Breed();
            breed.setESubmitValue(entity.getEsubmitBreedCode());
            breed.setLimsValue(entity.getLimsBreedCode());
            breedList.add(breed);
        }
        return breedList;
    }

    private List<Species> mapSpeciesEntityListToSpeciesTypeList(List<EsubmitSpeciesMappingEntity> esubmitSpeciesMappingEntities) {
        List<Species> speciesList = new ArrayList<>();
        for(EsubmitSpeciesMappingEntity entity : esubmitSpeciesMappingEntities){
            Species species = new Species();
            species.setESubmitValue(entity.getEsubmitSpeciesCode());
            species.setLimsValue(entity.getLimsSpeciesCode());
            speciesList.add(species);
        }
        return speciesList;
    }

}

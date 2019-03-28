package com.idexx.applications.lynxx.microservices.LYNXXConfigurationMicroserviceWeb.presentation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.idexx.applications.lynxx.microservices.LYNXXConfigurationMicroserviceWeb.application.ConfigurationManager;
import com.idexx.applications.lynxx.microservices.LYNXXConfigurationMicroserviceWeb.domain.model.datatypes.Breed;
import com.idexx.applications.lynxx.microservices.LYNXXConfigurationMicroserviceWeb.domain.model.datatypes.Gender;
import com.idexx.applications.lynxx.microservices.LYNXXConfigurationMicroserviceWeb.domain.model.datatypes.Species;
import com.idexx.applications.lynxx.microservices.LYNXXConfigurationMicroserviceWeb.presentation.dto.MappingDto;
import com.idexx.applications.lynxx.microservices.LYNXXConfigurationMicroserviceWeb.presentation.dto.MappingListDto;
import org.hibernate.result.NoMoreReturnsException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author fghaly
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class ConfigurationRestControllerTest {

    private MockMvc mockMvc;

    @Mock
    ConfigurationManager manager;

    @InjectMocks
    private ConfigurationRestController configurationRestController;

    MappingListDto mappingsDto = new MappingListDto();
    ObjectMapper objectMapper = new ObjectMapper();

    private static final String CONFIG_URL = "/ConfigMicroService";
    private static final String BREEDS_SVC_REGION = "/breeds/";
    private static final String SPECIES_SVC_REGION = "/species/";
    private static final String GENDER_SVC_REGION = "/gender/";


    @Before
    public void initMocks() {
        mockMvc = MockMvcBuilders.standaloneSetup(configurationRestController).build();
    }

    @Test
    public void getBreeds_success() throws Exception {
        List<Breed> breedList = getBreedList();
        for (Breed breed : breedList) {
            mappingsDto.addToList(objectMapper.convertValue(breed, MappingDto.class));
        }

        when(manager.retrieveBreedMappingByRegionId("1")).thenReturn(breedList);

        String jsonArr = objectMapper.writeValueAsString(mappingsDto);
        mockMvc.perform(get(CONFIG_URL + BREEDS_SVC_REGION + "1"))
                .andExpect(status().isOk())
                .andExpect(content().string(jsonArr));
    }

    @Test
    public void getSpecies_success() throws Exception {
        List<Species> speciesList = getSpeciesList();
        for (Species species : speciesList) {
            mappingsDto.addToList(objectMapper.convertValue(species, MappingDto.class));
        }

        when(manager.retrieveSpeciesMappingByRegionId("1")).thenReturn(speciesList);

        String jsonArr = objectMapper.writeValueAsString(mappingsDto);
        mockMvc.perform(get(CONFIG_URL + SPECIES_SVC_REGION + "1"))
                .andExpect(status().isOk())
                .andExpect(content().string(jsonArr));
    }

    @Test
    public void getGender_success() throws Exception {
        List<Gender> genderList = getGenderList();
        for (Gender gender : genderList) {
            mappingsDto.addToList(objectMapper.convertValue(gender, MappingDto.class));
        }

        when(manager.retrieveGenderMappingByRegionId("1")).thenReturn(genderList);

        String jsonArr = objectMapper.writeValueAsString(mappingsDto);
        mockMvc.perform(get(CONFIG_URL + GENDER_SVC_REGION + "1"))
                .andExpect(status().isOk())
                .andExpect(content().string(jsonArr));
    }

    @Test
    public void getBreeds_empty() throws Exception {
        List<Breed> breedList = new ArrayList<>();
        for (Breed breed : breedList) {
            mappingsDto.addToList(objectMapper.convertValue(breed, MappingDto.class));
        }

        when(manager.retrieveBreedMappingByRegionId("2")).thenReturn(breedList);

        String jsonArr = objectMapper.writeValueAsString(mappingsDto);
        mockMvc.perform(get(CONFIG_URL + BREEDS_SVC_REGION + "2"))
                .andExpect(status().isOk())
                .andExpect(content().string(jsonArr));
    }

    @Test
    public void getBreeds_failure() throws Exception {

        when(manager.retrieveBreedMappingByRegionId("2")).thenThrow(NoMoreReturnsException.class);

        mockMvc.perform(get(CONFIG_URL + BREEDS_SVC_REGION + "2"))
                .andExpect(status().is5xxServerError());
    }

    @Test
    public void getGenders_empty() throws Exception {
        List<Gender> genderList = new ArrayList<>();
        for (Gender gender : genderList) {
            mappingsDto.addToList(objectMapper.convertValue(gender, MappingDto.class));
        }

        when(manager.retrieveGenderMappingByRegionId("2")).thenReturn(genderList);

        String jsonArr = objectMapper.writeValueAsString(mappingsDto);
        mockMvc.perform(get(CONFIG_URL + GENDER_SVC_REGION + "2"))
                .andExpect(status().isOk())
                .andExpect(content().string(jsonArr));
    }

    @Test
    public void getGenders_failure() throws Exception {

        when(manager.retrieveGenderMappingByRegionId("2")).thenThrow(NoMoreReturnsException.class);

        mockMvc.perform(get(CONFIG_URL + GENDER_SVC_REGION + "2"))
                .andExpect(status().is5xxServerError());
    }

    @Test
    public void getSpecies_empty() throws Exception {
        List<Species> speciesList = new ArrayList<>();
        for (Species species : speciesList) {
            mappingsDto.addToList(objectMapper.convertValue(species, MappingDto.class));
        }

        when(manager.retrieveSpeciesMappingByRegionId("2")).thenReturn(speciesList);

        String jsonArr = objectMapper.writeValueAsString(mappingsDto);
        mockMvc.perform(get(CONFIG_URL + SPECIES_SVC_REGION + "2"))
                .andExpect(status().isOk())
                .andExpect(content().string(jsonArr));
    }

    @Test
    public void getSpecies_failure() throws Exception {

        when(manager.retrieveSpeciesMappingByRegionId("2")).thenThrow(NoMoreReturnsException.class);

        mockMvc.perform(get(CONFIG_URL + SPECIES_SVC_REGION + "2"))
                .andExpect(status().is5xxServerError());
    }

    private List<Breed> getBreedList(){
        List<Breed> breedList = new ArrayList<>();
        Breed breed1 = new Breed();
        breed1.setESubmitValue("KENY_GUINEAFOWL");
        breed1.setLimsValue("KENYACRESTED_GUINEAFOWL");
        breedList.add(breed1);
        Breed breed2 = new Breed();
        breed2.setESubmitValue("INDPYG_GOOSE");
        breed2.setLimsValue("INDIANPYGMY_GOOSE");
        breedList.add(breed2);
        return breedList;
    }

    private List<Gender> getGenderList(){
        List<Gender> genderList = new ArrayList<>();
        Gender gender1 = new Gender();
        gender1.setESubmitValue("FEMALE_INTACT");
        gender1.setLimsValue("FI");
        genderList.add(gender1);
        Gender gender2 = new Gender();
        gender2.setESubmitValue("MALE_NEUTERED");
        gender2.setLimsValue("MN");
        genderList.add(gender2);
        return genderList;
    }

    private List<Species> getSpeciesList(){
        List<Species> speciesList = new ArrayList<>();
        Species species1 = new Species();
        species1.setESubmitValue("KANGAROO");
        species1.setLimsValue("ZMAMMAL");
        speciesList.add(species1);
        Species species2 = new Species();
        species2.setESubmitValue("LEOPARD_TORTOISE");
        species2.setLimsValue("RLEOPTORT");
        speciesList.add(species2);
        return speciesList;
    }
}

package com.idexx.applications.lynxx.microservices.LYNXXConfigurationMicroserviceWeb.integration.dataservices.dao;

import com.idexx.applications.lynxx.microservices.LYNXXConfigurationMicroserviceWeb.integration.dataservices.entities.EsubmitSpeciesMappingEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * @author fghaly
 */

@Service
public class SpeciesDAO {
    @Autowired
    private EntityManager entityManager;

    public List<EsubmitSpeciesMappingEntity> retrieveSpeciesListByRegionId(Integer regionId) {
        Query namedQuery = entityManager.createNamedQuery("EsubmitSpeciesMappingEntity.retrieveSpeciesListByRegionId");
        namedQuery.setParameter("regionId", regionId);
        return namedQuery.getResultList();
    }
}

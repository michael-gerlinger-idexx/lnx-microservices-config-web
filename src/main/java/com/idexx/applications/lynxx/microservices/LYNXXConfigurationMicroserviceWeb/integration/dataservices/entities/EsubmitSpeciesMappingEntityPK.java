package com.idexx.applications.lynxx.microservices.LYNXXConfigurationMicroserviceWeb.integration.dataservices.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author fghaly
 */
public class EsubmitSpeciesMappingEntityPK implements Serializable {
    private String esubmitSpeciesCode;
    private String limsSpeciesCode;
    private Integer limsRegionId;

    @Column(name = "ESUBMIT_SPECIES_CODE")
    @Id
    public String getEsubmitSpeciesCode() {
        return esubmitSpeciesCode;
    }

    public void setEsubmitSpeciesCode(String esubmitSpeciesCode) {
        this.esubmitSpeciesCode = esubmitSpeciesCode;
    }

    @Column(name = "LIMS_SPECIES_CODE")
    @Id
    public String getLimsSpeciesCode() {
        return limsSpeciesCode;
    }

    public void setLimsSpeciesCode(String limsSpeciesCode) {
        this.limsSpeciesCode = limsSpeciesCode;
    }

    @Column(name = "LIMS_REGION_ID")
    @Id
    public Integer getLimsRegionId() {
        return limsRegionId;
    }

    public void setLimsRegionId(Integer limsRegionId) {
        this.limsRegionId = limsRegionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EsubmitSpeciesMappingEntityPK that = (EsubmitSpeciesMappingEntityPK) o;

        if (esubmitSpeciesCode != null ? !esubmitSpeciesCode.equals(that.esubmitSpeciesCode) : that.esubmitSpeciesCode != null)
            return false;
        if (limsSpeciesCode != null ? !limsSpeciesCode.equals(that.limsSpeciesCode) : that.limsSpeciesCode != null)
            return false;
        if (limsRegionId != null ? !limsRegionId.equals(that.limsRegionId) : that.limsRegionId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = esubmitSpeciesCode != null ? esubmitSpeciesCode.hashCode() : 0;
        result = 31 * result + (limsSpeciesCode != null ? limsSpeciesCode.hashCode() : 0);
        result = 31 * result + (limsRegionId != null ? limsRegionId.hashCode() : 0);
        return result;
    }
}

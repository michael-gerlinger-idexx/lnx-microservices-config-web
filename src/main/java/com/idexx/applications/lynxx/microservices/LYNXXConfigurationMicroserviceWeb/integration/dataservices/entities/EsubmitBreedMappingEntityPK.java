package com.idexx.applications.lynxx.microservices.LYNXXConfigurationMicroserviceWeb.integration.dataservices.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author fghaly
 */
public class EsubmitBreedMappingEntityPK implements Serializable {
    private String esubmitBreedCode;
    private String esubmitSpeciesCode;
    private String limsBreedCode;
    private Integer limsRegionId;

    @Column(name = "ESUBMIT_BREED_CODE")
    @Id
    public String getEsubmitBreedCode() {
        return esubmitBreedCode;
    }

    public void setEsubmitBreedCode(String esubmitBreedCode) {
        this.esubmitBreedCode = esubmitBreedCode;
    }

    @Column(name = "ESUBMIT_SPECIES_CODE")
    @Id
    public String getEsubmitSpeciesCode() {
        return esubmitSpeciesCode;
    }

    public void setEsubmitSpeciesCode(String esubmitSpeciesCode) {
        this.esubmitSpeciesCode = esubmitSpeciesCode;
    }

    @Column(name = "LIMS_BREED_CODE")
    @Id
    public String getLimsBreedCode() {
        return limsBreedCode;
    }

    public void setLimsBreedCode(String limsBreedCode) {
        this.limsBreedCode = limsBreedCode;
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

        EsubmitBreedMappingEntityPK that = (EsubmitBreedMappingEntityPK) o;

        if (esubmitBreedCode != null ? !esubmitBreedCode.equals(that.esubmitBreedCode) : that.esubmitBreedCode != null)
            return false;
        if (esubmitSpeciesCode != null ? !esubmitSpeciesCode.equals(that.esubmitSpeciesCode) : that.esubmitSpeciesCode != null)
            return false;
        if (limsBreedCode != null ? !limsBreedCode.equals(that.limsBreedCode) : that.limsBreedCode != null)
            return false;
        if (limsRegionId != null ? !limsRegionId.equals(that.limsRegionId) : that.limsRegionId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = esubmitBreedCode != null ? esubmitBreedCode.hashCode() : 0;
        result = 31 * result + (esubmitSpeciesCode != null ? esubmitSpeciesCode.hashCode() : 0);
        result = 31 * result + (limsBreedCode != null ? limsBreedCode.hashCode() : 0);
        result = 31 * result + (limsRegionId != null ? limsRegionId.hashCode() : 0);
        return result;
    }
}

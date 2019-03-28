package com.idexx.applications.lynxx.microservices.LYNXXConfigurationMicroserviceWeb.integration.dataservices.entities;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author fghaly
 */
@Entity
@Table(name = "ESUBMIT_SPECIES_MAPPING", schema = "LYNXX")
@NamedQueries({
        @NamedQuery(name = "EsubmitSpeciesMappingEntity.retrieveSpeciesListByRegionId", query = "select s from EsubmitSpeciesMappingEntity s where s.limsRegionId = :regionId")
})
@IdClass(EsubmitSpeciesMappingEntityPK.class)
public class EsubmitSpeciesMappingEntity{
    private String esubmitSpeciesCode;
    private String esubmitSpeciesName;
    private String esubmitSpeciesType;
    private String limsSpeciesCode;
    private String limsSpeciesSubCode;
    private Integer limsRegionId;
    private Timestamp addedDate;

    @Id
    @Column(name = "ESUBMIT_SPECIES_CODE")
    public String getEsubmitSpeciesCode() {
        return esubmitSpeciesCode;
    }

    public void setEsubmitSpeciesCode(String esubmitSpeciesCode) {
        this.esubmitSpeciesCode = esubmitSpeciesCode;
    }

    @Basic
    @Column(name = "ESUBMIT_SPECIES_NAME")
    public String getEsubmitSpeciesName() {
        return esubmitSpeciesName;
    }

    public void setEsubmitSpeciesName(String esubmitSpeciesName) {
        this.esubmitSpeciesName = esubmitSpeciesName;
    }

    @Basic
    @Column(name = "ESUBMIT_SPECIES_TYPE")
    public String getEsubmitSpeciesType() {
        return esubmitSpeciesType;
    }

    public void setEsubmitSpeciesType(String esubmitSpeciesType) {
        this.esubmitSpeciesType = esubmitSpeciesType;
    }

    @Id
    @Column(name = "LIMS_SPECIES_CODE")
    public String getLimsSpeciesCode() {
        return limsSpeciesCode;
    }

    public void setLimsSpeciesCode(String limsSpeciesCode) {
        this.limsSpeciesCode = limsSpeciesCode;
    }

    @Basic
    @Column(name = "LIMS_SPECIES_SUB_CODE")
    public String getLimsSpeciesSubCode() {
        return limsSpeciesSubCode;
    }

    public void setLimsSpeciesSubCode(String limsSpeciesSubCode) {
        this.limsSpeciesSubCode = limsSpeciesSubCode;
    }

    @Id
    @Column(name = "LIMS_REGION_ID")
    public Integer getLimsRegionId() {
        return limsRegionId;
    }

    public void setLimsRegionId(Integer limsRegionId) {
        this.limsRegionId = limsRegionId;
    }

    @Basic
    @Column(name = "ADDED_DATE")
    public Timestamp getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Timestamp addedDate) {
        this.addedDate = addedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EsubmitSpeciesMappingEntity that = (EsubmitSpeciesMappingEntity) o;

        if (esubmitSpeciesCode != null ? !esubmitSpeciesCode.equals(that.esubmitSpeciesCode) : that.esubmitSpeciesCode != null)
            return false;
        if (esubmitSpeciesName != null ? !esubmitSpeciesName.equals(that.esubmitSpeciesName) : that.esubmitSpeciesName != null)
            return false;
        if (esubmitSpeciesType != null ? !esubmitSpeciesType.equals(that.esubmitSpeciesType) : that.esubmitSpeciesType != null)
            return false;
        if (limsSpeciesCode != null ? !limsSpeciesCode.equals(that.limsSpeciesCode) : that.limsSpeciesCode != null)
            return false;
        if (limsSpeciesSubCode != null ? !limsSpeciesSubCode.equals(that.limsSpeciesSubCode) : that.limsSpeciesSubCode != null)
            return false;
        if (limsRegionId != null ? !limsRegionId.equals(that.limsRegionId) : that.limsRegionId != null) return false;
        if (addedDate != null ? !addedDate.equals(that.addedDate) : that.addedDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = esubmitSpeciesCode != null ? esubmitSpeciesCode.hashCode() : 0;
        result = 31 * result + (esubmitSpeciesName != null ? esubmitSpeciesName.hashCode() : 0);
        result = 31 * result + (esubmitSpeciesType != null ? esubmitSpeciesType.hashCode() : 0);
        result = 31 * result + (limsSpeciesCode != null ? limsSpeciesCode.hashCode() : 0);
        result = 31 * result + (limsSpeciesSubCode != null ? limsSpeciesSubCode.hashCode() : 0);
        result = 31 * result + (limsRegionId != null ? limsRegionId.hashCode() : 0);
        result = 31 * result + (addedDate != null ? addedDate.hashCode() : 0);
        return result;
    }
}

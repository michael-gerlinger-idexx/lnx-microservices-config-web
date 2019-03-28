package com.idexx.applications.lynxx.microservices.LYNXXConfigurationMicroserviceWeb.integration.dataservices.entities;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author fghaly
 */
@Entity
@Table(name = "ESUBMIT_BREED_MAPPING", schema = "LYNXX")
@NamedQueries({
        @NamedQuery(name = "EsubmitBreedMappingEntity.retrieveBreedsListByRegionId", query = "select b from EsubmitBreedMappingEntity b where b.limsRegionId = :regionId")
})
@IdClass(EsubmitBreedMappingEntityPK.class)
public class EsubmitBreedMappingEntity{
    private String esubmitBreedCode;
    private String esubmitBreedName;
    private String esubmitSpeciesCode;
    private String limsBreedCode;
    private Integer limsRegionId;
    private Timestamp addedDate;

    @Id
    @Column(name = "ESUBMIT_BREED_CODE")
    public String getEsubmitBreedCode() {
        return esubmitBreedCode;
    }

    public void setEsubmitBreedCode(String esubmitBreedCode) {
        this.esubmitBreedCode = esubmitBreedCode;
    }

    @Basic
    @Column(name = "ESUBMIT_BREED_NAME")
    public String getEsubmitBreedName() {
        return esubmitBreedName;
    }

    public void setEsubmitBreedName(String esubmitBreedName) {
        this.esubmitBreedName = esubmitBreedName;
    }

    @Id
    @Column(name = "ESUBMIT_SPECIES_CODE")
    public String getEsubmitSpeciesCode() {
        return esubmitSpeciesCode;
    }

    public void setEsubmitSpeciesCode(String esubmitSpeciesCode) {
        this.esubmitSpeciesCode = esubmitSpeciesCode;
    }

    @Id
    @Column(name = "LIMS_BREED_CODE")
    public String getLimsBreedCode() {
        return limsBreedCode;
    }

    public void setLimsBreedCode(String limsBreedCode) {
        this.limsBreedCode = limsBreedCode;
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

        EsubmitBreedMappingEntity that = (EsubmitBreedMappingEntity) o;

        if (esubmitBreedCode != null ? !esubmitBreedCode.equals(that.esubmitBreedCode) : that.esubmitBreedCode != null)
            return false;
        if (esubmitBreedName != null ? !esubmitBreedName.equals(that.esubmitBreedName) : that.esubmitBreedName != null)
            return false;
        if (esubmitSpeciesCode != null ? !esubmitSpeciesCode.equals(that.esubmitSpeciesCode) : that.esubmitSpeciesCode != null)
            return false;
        if (limsBreedCode != null ? !limsBreedCode.equals(that.limsBreedCode) : that.limsBreedCode != null)
            return false;
        if (limsRegionId != null ? !limsRegionId.equals(that.limsRegionId) : that.limsRegionId != null) return false;
        if (addedDate != null ? !addedDate.equals(that.addedDate) : that.addedDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = esubmitBreedCode != null ? esubmitBreedCode.hashCode() : 0;
        result = 31 * result + (esubmitBreedName != null ? esubmitBreedName.hashCode() : 0);
        result = 31 * result + (esubmitSpeciesCode != null ? esubmitSpeciesCode.hashCode() : 0);
        result = 31 * result + (limsBreedCode != null ? limsBreedCode.hashCode() : 0);
        result = 31 * result + (limsRegionId != null ? limsRegionId.hashCode() : 0);
        result = 31 * result + (addedDate != null ? addedDate.hashCode() : 0);
        return result;
    }
}

package com.idexx.applications.lynxx.microservices.LYNXXConfigurationMicroserviceWeb.integration.dataservices.entities;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author fghaly
 */
@Entity
@Table(name = "ESUBMIT_GENDER_MAPPING", schema = "LYNXX")
@NamedQueries({
        @NamedQuery(name = "EsubmitGenderMappingEntity.retrieveGendersListByRegionId", query = "select g from EsubmitGenderMappingEntity g where g.limsRegionId = :regionId")
})
@IdClass(EsubmitGenderMappingEntityPK.class)
public class EsubmitGenderMappingEntity{
    private String esubmitGenderCode;
    private String limsGenderCode;
    private Integer limsRegionId;
    private Timestamp addedDate;

    @Id
    @Column(name = "ESUBMIT_GENDER_CODE")
    public String getEsubmitGenderCode() {
        return esubmitGenderCode;
    }

    public void setEsubmitGenderCode(String esubmitGenderCode) {
        this.esubmitGenderCode = esubmitGenderCode;
    }

    @Id
    @Column(name = "LIMS_GENDER_CODE")
    public String getLimsGenderCode() {
        return limsGenderCode;
    }

    public void setLimsGenderCode(String limsGenderCode) {
        this.limsGenderCode = limsGenderCode;
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

        EsubmitGenderMappingEntity that = (EsubmitGenderMappingEntity) o;

        if (esubmitGenderCode != null ? !esubmitGenderCode.equals(that.esubmitGenderCode) : that.esubmitGenderCode != null)
            return false;
        if (limsGenderCode != null ? !limsGenderCode.equals(that.limsGenderCode) : that.limsGenderCode != null)
            return false;
        if (limsRegionId != null ? !limsRegionId.equals(that.limsRegionId) : that.limsRegionId != null) return false;
        if (addedDate != null ? !addedDate.equals(that.addedDate) : that.addedDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = esubmitGenderCode != null ? esubmitGenderCode.hashCode() : 0;
        result = 31 * result + (limsGenderCode != null ? limsGenderCode.hashCode() : 0);
        result = 31 * result + (limsRegionId != null ? limsRegionId.hashCode() : 0);
        result = 31 * result + (addedDate != null ? addedDate.hashCode() : 0);
        return result;
    }
}

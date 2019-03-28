package com.idexx.applications.lynxx.microservices.LYNXXConfigurationMicroserviceWeb.integration.dataservices.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author fghaly
 */
public class EsubmitGenderMappingEntityPK implements Serializable {
    private String esubmitGenderCode;
    private String limsGenderCode;
    private Integer limsRegionId;

    @Column(name = "ESUBMIT_GENDER_CODE")
    @Id
    public String getEsubmitGenderCode() {
        return esubmitGenderCode;
    }

    public void setEsubmitGenderCode(String esubmitGenderCode) {
        this.esubmitGenderCode = esubmitGenderCode;
    }

    @Column(name = "LIMS_GENDER_CODE")
    @Id
    public String getLimsGenderCode() {
        return limsGenderCode;
    }

    public void setLimsGenderCode(String limsGenderCode) {
        this.limsGenderCode = limsGenderCode;
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

        EsubmitGenderMappingEntityPK that = (EsubmitGenderMappingEntityPK) o;

        if (esubmitGenderCode != null ? !esubmitGenderCode.equals(that.esubmitGenderCode) : that.esubmitGenderCode != null)
            return false;
        if (limsGenderCode != null ? !limsGenderCode.equals(that.limsGenderCode) : that.limsGenderCode != null)
            return false;
        if (limsRegionId != null ? !limsRegionId.equals(that.limsRegionId) : that.limsRegionId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = esubmitGenderCode != null ? esubmitGenderCode.hashCode() : 0;
        result = 31 * result + (limsGenderCode != null ? limsGenderCode.hashCode() : 0);
        result = 31 * result + (limsRegionId != null ? limsRegionId.hashCode() : 0);
        return result;
    }
}

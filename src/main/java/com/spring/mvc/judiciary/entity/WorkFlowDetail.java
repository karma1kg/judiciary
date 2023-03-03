package com.spring.mvc.judiciary.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by USER on 8/6/2019.
 */
@Entity
@Table(name = "t_workflow_dtls")
public class WorkFlowDetail {
    //region private variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Workflow_instance_Id")
    private Integer workFlowInstanceId;

    @Column(name = "Application_Id")
    private String applicationNo;

    @Column(name = "Application_Status")
    private Integer applicationStatusId;

    @Column(name = "Service_Id")
    private Integer serviceId;

    @Column(name = "Created_Date")
    private Date createdDate;

    @Column(name = "Created_By")
    private String createdBy;

    @Column(name = "Modified_By")
    private String updateBy;

    @Column(name = "Modified_Date")
    private Date updateDate;
    //endregion

    //region setters and getters


    public Integer getWorkFlowInstanceId() {
        return workFlowInstanceId;
    }

    public void setWorkFlowInstanceId(Integer workFlowInstanceId) {
        this.workFlowInstanceId = workFlowInstanceId;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getApplicationNo() {
        return applicationNo;
    }

    public void setApplicationNo(String applicationNo) {
        this.applicationNo = applicationNo;
    }

    public Integer getApplicationStatusId() {
        return applicationStatusId;
    }

    public void setApplicationStatusId(Integer applicationStatusId) {
        this.applicationStatusId = applicationStatusId;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    //endregion
}

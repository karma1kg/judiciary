package com.spring.mvc.judiciary.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by USER on 8/7/2019.
 */
@Entity
@Table(name = "t_task_dtls")
public class TaskDetail {
    //region private variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Task_instance_Id")
    private Integer taskInstanceId;

    @Column(name = "Application_Id")
    private String applicationNo;

    @Column(name = "Service_Id")
    private Integer serviceId;

    @Column(name = "Owner")
    private String owner;

    @Column(name = "Created_By")
    private String createdBy;

    @Column(name = "Created_on")
    private Date createdOn;

    @Column(name = "Modified_By")
    private String modifiedBy;

    @Column(name = "Modified_On")
    private Date modifiedOn;

    @Column(name = "Application_Status")
    private Integer applicationStatus;

    @Column(name = "Workflow_Instance_Id")
    private String workflowInstanceId;
    //endregion

    //region setters and getters


    public Integer getTaskInstanceId() {
        return taskInstanceId;
    }

    public void setTaskInstanceId(Integer taskInstanceId) {
        this.taskInstanceId = taskInstanceId;
    }

    public String getApplicationNo() {
        return applicationNo;
    }

    public void setApplicationNo(String applicationNo) {
        this.applicationNo = applicationNo;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public Integer getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(Integer applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public String getWorkflowInstanceId() {
        return workflowInstanceId;
    }

    public void setWorkflowInstanceId(String workflowInstanceId) {
        this.workflowInstanceId = workflowInstanceId;
    }

    //endregion
}

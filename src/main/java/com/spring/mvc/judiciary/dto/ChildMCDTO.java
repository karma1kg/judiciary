package com.spring.mvc.judiciary.dto;

import java.util.Date;

/**
 * Created by Sonam Tobgay on 3/11/2020.
 */
public class ChildMCDTO {

    //region private variables
    private Integer childId;
    private String applicationNo;
    private String childName;
    private Date childDoB;
    private String childGender;
    //endregion

    //region setters and getters
    public Integer getChildId() {
        return childId;
    }

    public void setChildId(Integer childId) {
        this.childId = childId;
    }

    public String getApplicationNo() {
        return applicationNo;
    }

    public void setApplicationNo(String applicationNo) {
        this.applicationNo = applicationNo;
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public Date getChildDoB() {
        return childDoB;
    }

    public void setChildDoB(Date childDoB) {
        this.childDoB = childDoB;
    }

    public String getChildGender() {
        return childGender;
    }

    public void setChildGender(String childGender) {
        this.childGender = childGender;
    }
    //endregion
}

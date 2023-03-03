package com.spring.mvc.judiciary.entity;

import org.hibernate.exception.DataException;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Sonam Tobgay on 3/11/2020.
 */
@Entity
@Table(name = "t_child_details_mc")
public class ChildMcDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CHILD_ID")
    private Integer childId;

    @Column(name = "APPLICATION_NO")
    private String applicationNo;

    @Column(name = "NAME")
    private String childName;

    @Column(name = "DoB")
    private Date childDoB;

    @Column(name = "GENDER")
    private String childGender;

    //region for setter and getter
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
}

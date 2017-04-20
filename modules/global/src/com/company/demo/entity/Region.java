package com.company.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s|title")
@Table(name = "DEMO_REGION")
@Entity(name = "demo$Region")
public class Region extends StandardEntity {
    private static final long serialVersionUID = 3679799155370932745L;

    @Column(name = "TITLE", nullable = false)
    protected String title;

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }


}
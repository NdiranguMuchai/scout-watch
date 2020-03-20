package com.ndirangu.scoutwatch.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "position")
public class Position extends BaseEntity {
    private String name;
    private String abbreviation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
}

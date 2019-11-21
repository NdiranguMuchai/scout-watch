package com.ndirangu.scoutwatch.model;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Team {
private String name;
private Country location;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getLocation() {
        return location;
    }

    public void setLocation(Country location) {
        this.location = location;
    }
}

package com.ndirangu.scoutwatch.model;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Team extends BaseEntity {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

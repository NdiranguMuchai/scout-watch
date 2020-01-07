package com.ndirangu.scoutwatch.model;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Person extends BaseEntity{
    private String firstName;
    private String LastName;
    private Country nationality;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public Country getNationality() {
        return nationality;
    }

    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }
}

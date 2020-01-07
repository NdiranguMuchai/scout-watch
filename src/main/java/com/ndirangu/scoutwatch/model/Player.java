package com.ndirangu.scoutwatch.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class Player extends Person{

    @NotNull(message = "Position is required")
    private String position;
    @NotNull(message = "Value is required")
    private float value;
    @ManyToOne
    @JoinColumn(name = "club_id")
    private Club club ;
    public Player(){}


    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }


    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }


}

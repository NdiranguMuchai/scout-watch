package com.ndirangu.scoutwatch.model;


import javax.persistence.*;

@Entity
@Table(name = "player")
public class Player  extends Person{

    @ManyToOne
    private Club club;

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }
}

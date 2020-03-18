package com.ndirangu.scoutwatch.model;


import javax.persistence.*;

@Entity
@Table(name = "coach")
public class Coach extends Person{

    @OneToOne(mappedBy = "coach")
    private Club club;

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }
}

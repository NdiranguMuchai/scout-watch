package com.ndirangu.scoutwatch.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
public class NationalTeam extends Team {

    @OneToOne
    private Coach coach;
    @OneToMany(mappedBy = "club")
    private Set<Player> players = new HashSet<>();

    public NationalTeam(){}


    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }
}

package com.ndirangu.scoutwatch.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "club")
public class Club  extends Team{

    @OneToMany(mappedBy = "club")
    private Set<Player> players = new HashSet<>();

    @OneToOne
    private Coach coach;

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }
}

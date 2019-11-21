package com.ndirangu.scoutwatch.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

public class NationalTeam extends Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private Coach coach;
    @OneToMany(mappedBy = "club")
    private Set<Player> players = new HashSet<>();

    public NationalTeam(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

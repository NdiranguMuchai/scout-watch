package com.ndirangu.scoutwatch.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "player")
public class Player  extends Person{

    @ManyToOne
    private Club club;

    @ManyToMany
    @JoinTable(name = "player_position",
            joinColumns = @JoinColumn(name = "player_id"),
            inverseJoinColumns = @JoinColumn(name = "position_id"))
    private Set <Position> positions = new HashSet<>();

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public Set<Position> getPositions() {
        return positions;
    }

    public void setPositions(Set<Position> positions) {
        this.positions = positions;
    }
}

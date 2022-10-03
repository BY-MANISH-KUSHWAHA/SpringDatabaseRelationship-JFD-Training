package com.spring.database.relationship.SpringDBRelationship.OneToManyBiDirectional.Entity;


import javax.persistence.*;

@Entity
public class Registration {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name="player_id",referencedColumnName = "id")
    private Player player;

    public Registration() {
    }

    public Registration(int id, Player player) {
        this.id = id; this.player = player;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "id=" + id +
                ", player=" + player +
                '}';
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}

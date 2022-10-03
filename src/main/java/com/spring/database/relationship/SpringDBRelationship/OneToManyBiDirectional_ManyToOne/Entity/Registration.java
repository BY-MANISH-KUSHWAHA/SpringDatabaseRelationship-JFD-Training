package com.spring.database.relationship.SpringDBRelationship.OneToManyBiDirectional_ManyToOne.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Registration {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="player_id",referencedColumnName = "id")
    //@JsonBackReference
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
        System.out.println(player+"44444444444444444444444"+this);
        Player p = new Player();
        this.player = p;
        this.player.setId(player.getId());
        this.player.setName(player.getName());
        this.player.setPlayerProfile(player.getPlayerProfile());
        //this.player.setRegistrationList(player.getRegistrationList());// With Modified Set Method

    }
}

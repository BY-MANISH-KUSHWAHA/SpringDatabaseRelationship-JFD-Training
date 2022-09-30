package com.spring.database.relationship.SpringDBRelationship.OneToOne.Entity;


import javax.persistence.*;

@Entity
public class Player {
    //@Id make primary key
    //@GeneratedValue give auto generated value
    @Id
    @GeneratedValue
    private int id; // key for joint

    // build 1-1 relationship unidirectional with player profile object into player
    // and we are setting profile id with referenced column id of playerProfile
    /*
        (UniDirectional 1-1) because player have access of profile but profile doesn't have.
    */
    // cascade will try to reflect all changes in Player entity will reflect in PlayerProfile class

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id",referencedColumnName = "id")
    private PlayerProfile playerProfile;

    private String name;

    public PlayerProfile getPlayerProfile() {
        return playerProfile;
    }

    public void setPlayerProfile(PlayerProfile playerProfile) {
        this.playerProfile = playerProfile;
    }

    public Player() {
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", playerProfile=" + playerProfile +
                ", name='" + name + '\'' +
                '}';
    }

    public Player(int id, PlayerProfile playerProfile, String name) {
        this.id = id;
        this.playerProfile = playerProfile;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }



    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}

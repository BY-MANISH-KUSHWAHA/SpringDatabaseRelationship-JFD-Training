package com.spring.database.relationship.SpringDBRelationship.OneToManyBiDirectional_ManyToOne.Entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Player {
    //@Id make primary key
    //@GeneratedValue give auto generated value
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToMany(mappedBy = "player", orphanRemoval = true)
    //@JsonManagedReference
    private List<Registration> registrationList = new ArrayList<>();

    public void registerPlayer(Registration registration){
        // add registration to the list
        System.out.println("11111111111111111111111111111111111"+this.registrationList);
        this.registrationList.add(registration);
        // setting the player filed using this in registration
        System.out.println("222222222222222222222222222222222222"+registration);
        registration.setPlayer(this);
        System.out.println("333333333333333333333333333333333333");

    }

    public void removeRegistartion(Registration registration){
        if(registrationList.size()!=0)  registrationList.remove(registration);
        registration.setPlayer(null);
    }

    private String name;

    public PlayerProfile getPlayerProfile() {
        return playerProfile;
    }

    public void setPlayerProfile(PlayerProfile playerProfile) {
        this.playerProfile = playerProfile;
    }

    public Player() {
    }



    public Player(int id, PlayerProfile playerProfile, String name, List<Registration> registrationList) {
        this.id = id;
        this.playerProfile = playerProfile;
        this.name = name;
        this.registrationList = registrationList;
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

    public List<Registration> getRegistrationList() {
        return registrationList;
    }




    public void setRegistrationList(List<Registration> registrationList) {
        this.registrationList = registrationList;
    }


    // Setting Up Bidirectional relationship with registration class


    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", playerProfile=" + playerProfile +
                ", name='" + name + '\'' +
                ", registrationList=" + registrationList +
                '}';
    }
}

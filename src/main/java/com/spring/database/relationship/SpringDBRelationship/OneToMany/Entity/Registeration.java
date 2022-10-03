package com.spring.database.relationship.SpringDBRelationship.OneToMany.Entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Registeration {

    @Id
    @GeneratedValue
    private int id;

    public Registeration() {
    }

    public Registeration(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Registeration{" +
                "id=" + id +
                '}';
    }
}

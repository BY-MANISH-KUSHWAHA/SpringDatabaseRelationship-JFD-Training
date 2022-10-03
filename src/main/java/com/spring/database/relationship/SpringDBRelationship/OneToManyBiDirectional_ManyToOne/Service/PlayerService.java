package com.spring.database.relationship.SpringDBRelationship.OneToManyBiDirectional_ManyToOne.Service;


import com.spring.database.relationship.SpringDBRelationship.OneToManyBiDirectional_ManyToOne.Entity.Player;
import com.spring.database.relationship.SpringDBRelationship.OneToManyBiDirectional_ManyToOne.Entity.PlayerProfile;
import com.spring.database.relationship.SpringDBRelationship.OneToManyBiDirectional_ManyToOne.Entity.Registration;
import com.spring.database.relationship.SpringDBRelationship.OneToManyBiDirectional_ManyToOne.Repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository repo;

    public List<com.spring.database.relationship.SpringDBRelationship.OneToManyBiDirectional_ManyToOne.Entity.Player> getAllPlayer(){
        return repo.findAll();
    }

    public com.spring.database.relationship.SpringDBRelationship.OneToManyBiDirectional_ManyToOne.Entity.Player getPlayerByID(@PathVariable("id") int id){
        Optional<Player> player = repo.findById(id);
        if(player.isPresent())  return player.get();
        throw new RuntimeException("Payer with Id="+id+" not found.");
    }

    public Player addPlayer(Player player){
        return repo.save(player);
    }

    public void deletePlayerById(int id){
        Optional<Player> p = repo.findById(id);
        if(p.isEmpty())  throw new RuntimeException("Payer with Id="+id+" not found.");
        repo.delete(p.get());
    }

    public Player assignProfile(int id, PlayerProfile profile){
        // We just take id{player} and profile_id and find player by its id and assign profile.
        Player player = repo.findById(id).get();

        player.setPlayerProfile(profile);

        return repo.save(player);

    }

    public Player addRegistration(int id, Registration registration){
        Player player = repo.findById(id).get();
        player.registerPlayer(registration);
        return player;

    }


    public Player removeRegistration(int id, Registration registration){
        System.out.println(id+" "+repo.findAll());
        Player player = repo.findById(id).get();
        player.removeRegistartion(registration);
        return repo.save(player);
    }
}

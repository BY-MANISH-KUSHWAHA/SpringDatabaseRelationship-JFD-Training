package com.spring.database.relationship.SpringDBRelationship.OneToOne.Service;

import com.spring.database.relationship.SpringDBRelationship.OneToOne.Entity.Player;
import com.spring.database.relationship.SpringDBRelationship.OneToOne.Repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository repo;

    public List<Player> getAllPlayer(){
        return repo.findAll();
    }

    public Player getPlayerByID(@PathVariable("id") int id){
        Optional<Player> player = repo.findById(id);
        if(player.isPresent())  return player.get();
        else throw new RuntimeException("Payer with Id="+id+" not found.");
    }

    public Player addPlayer(Player player){
        return repo.save(player);
    }

    public void deletePlayerById(int id){
        Optional<Player> p = repo.findById(id);
        if(p.isEmpty())  throw new RuntimeException("Payer with Id="+id+" not found.");
        repo.delete(p.get());
    }
}

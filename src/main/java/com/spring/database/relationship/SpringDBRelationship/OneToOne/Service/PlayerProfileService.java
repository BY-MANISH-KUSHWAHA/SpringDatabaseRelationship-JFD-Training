package com.spring.database.relationship.SpringDBRelationship.OneToOne.Service;

import com.spring.database.relationship.SpringDBRelationship.OneToOne.Entity.PlayerProfile;
import com.spring.database.relationship.SpringDBRelationship.OneToOne.Repository.PlayerProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerProfileService {
    @Autowired
    private PlayerProfileRepository repo;

    public List<PlayerProfile> getAllPlayerProfile(){
        return repo.findAll();
    }

    public PlayerProfile getPlayerProfileByID(@PathVariable("id") int id){
        Optional<PlayerProfile> playerProfile = repo.findById(id);
        if(playerProfile.isPresent())  return playerProfile.get();
        throw new RuntimeException("PayerProfile with Id="+id+" not found.");
    }

    public PlayerProfile addPlayerProfile(PlayerProfile playerProfile){
        return repo.save(playerProfile);
    }

    public void deletePlayerProfileById(int id){
        Optional<PlayerProfile> p = repo.findById(id);
        if(p.isEmpty())  throw new RuntimeException("PayerProfile with Id="+id+" not found.");
        repo.delete(p.get());
    }


}

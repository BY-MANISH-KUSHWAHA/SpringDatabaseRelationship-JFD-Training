package com.spring.database.relationship.SpringDBRelationship.OneToOne.Controller;

import com.spring.database.relationship.SpringDBRelationship.OneToOne.Entity.Player;
import com.spring.database.relationship.SpringDBRelationship.OneToOne.Entity.PlayerProfile;
import com.spring.database.relationship.SpringDBRelationship.OneToOne.Service.PlayerProfileService;
import com.spring.database.relationship.SpringDBRelationship.OneToOne.Service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {
    @Autowired
    PlayerService service;

    @Autowired
    PlayerProfileService profileService;

    @GetMapping
    public List<Player> getAllPlayer(){
        return service.getAllPlayer();
    }

    @GetMapping(value = "/playerById/{id}")
    public Player getPlayerByID(@PathVariable("id") int ID){
        return service.getPlayerByID(ID); // PathVariable Define in Controller
    }

    @PostMapping("/addPlayer")
    //@RequestMapping(method = RequestMethod.POST)
    public Player addPlayer(@RequestBody Player p){
        return service.addPlayer(p);
    }

    @DeleteMapping("/deletePlayer/{id}")
    public void deletePlayer(@PathVariable int id){
        service.deletePlayerById(id);
    }

    // ONE-TO-ONE RELATION
    // Assign Profile to Player after both created.
    @PutMapping("/{id}/profile/{profile_id}") // This from Player Entity
    public Player assignDetails(@PathVariable int id, @PathVariable int profile_id){
        // UniDirection
        PlayerProfile playerProfile = profileService.getPlayerProfileByID(profile_id);
        System.out.println();
        return service.assignProfile(id,playerProfile);
    }





}

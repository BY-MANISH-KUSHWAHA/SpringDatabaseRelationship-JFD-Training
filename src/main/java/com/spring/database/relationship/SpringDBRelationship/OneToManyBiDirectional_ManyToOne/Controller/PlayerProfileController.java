package com.spring.database.relationship.SpringDBRelationship.OneToManyBiDirectional_ManyToOne.Controller;


import com.spring.database.relationship.SpringDBRelationship.OneToManyBiDirectional_ManyToOne.Entity.PlayerProfile;
import com.spring.database.relationship.SpringDBRelationship.OneToManyBiDirectional_ManyToOne.Service.PlayerProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/playerProfiles") // default url
public class PlayerProfileController {
    @Autowired
    PlayerProfileService service;

    @GetMapping // take the default url
    public List<PlayerProfile> getAllPlayerProfile(){
        return service.getAllPlayerProfile();
    }

    @GetMapping(value = "/playerProfileById/{id}")
    public PlayerProfile getPlayerByID(@PathVariable("id") int ID){
        return service.getPlayerProfileByID(ID); // PathVariable Define in Controller
    }

    @PostMapping("/addPlayerProfile")
    //@RequestMapping(method = RequestMethod.POST)
    public PlayerProfile addPlayerProfile(@RequestBody PlayerProfile p){
        return service.addPlayerProfile(p);
    }

    @DeleteMapping("/deletePlayerProfile/{id}")
    public void deletePlayer(@PathVariable int id){
        service.deletePlayerProfileById(id);
    }

}

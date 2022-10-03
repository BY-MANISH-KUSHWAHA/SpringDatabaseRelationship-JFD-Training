package com.spring.database.relationship.SpringDBRelationship.OneToManyBiDirectional_ManyToOne.Controller;



import OneToMany.Repository.RegistrationRepository;
import com.spring.database.relationship.SpringDBRelationship.OneToManyBiDirectional_ManyToOne.Entity.Player;
import com.spring.database.relationship.SpringDBRelationship.OneToManyBiDirectional_ManyToOne.Entity.PlayerProfile;
import com.spring.database.relationship.SpringDBRelationship.OneToManyBiDirectional_ManyToOne.Entity.Registration;
import com.spring.database.relationship.SpringDBRelationship.OneToManyBiDirectional_ManyToOne.Service.PlayerProfileService;
import com.spring.database.relationship.SpringDBRelationship.OneToManyBiDirectional_ManyToOne.Service.PlayerService;
import com.spring.database.relationship.SpringDBRelationship.OneToManyBiDirectional_ManyToOne.Service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players") // Default Start Url
public class PlayerController {
    @Autowired
    PlayerService service;

    @Autowired
    PlayerProfileService profileService;

    @Autowired
    RegistrationService registrationService;

    @GetMapping // take default url.
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
        // Using profileService we fetch profile by profile_id and send it to assigning.
        PlayerProfile playerProfile = profileService.getPlayerProfileByID(profile_id);
        System.out.println();
        return service.assignProfile(id,playerProfile);
    }



    @PutMapping("/{id}/registration/{res_id}") // This from Player Entity
    public Player addRegistration(@PathVariable int id, @PathVariable int res_id){
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+service.getPlayerByID(id));
        Registration registration = registrationService.getRegistrationById(res_id);

        System.out.println(registration);
        return service.addRegistration(id,registration);
    }

    @PutMapping("/{id}/removeRegistration/{res_id}") // This from Player Entity
    public Player removeRegistration(@PathVariable int id, @PathVariable int res_id){
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        Registration registration = registrationService.getRegistrationById(res_id);
        System.out.println(registration);
        return service.removeRegistration(id,registration);
    }





}

package com.spring.database.relationship.SpringDBRelationship.OneToMany.Controller;

import com.spring.database.relationship.SpringDBRelationship.OneToMany.Entity.Registeration;
import com.spring.database.relationship.SpringDBRelationship.OneToMany.Entity.Tournament;
import com.spring.database.relationship.SpringDBRelationship.OneToMany.Service.RegisterationService;
import com.spring.database.relationship.SpringDBRelationship.OneToMany.Service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tournaments")
public class TournamentController {
    @Autowired
    TournamentService tournamentService;

    @Autowired
    RegisterationService registerationService;

    @GetMapping // take default url.
    public List<Tournament> getAllTournaments(){
        return tournamentService.getAllTournament();
    }

    @GetMapping(value = "/{id}")
    public Tournament getTournamentByID(@PathVariable("id") int ID){
        return tournamentService.getTournamentById(ID); // PathVariable Define in Controller
    }

    @PostMapping
    //@RequestMapping(method = RequestMethod.POST)
    public Tournament addTournament(@RequestBody Tournament tournament){
        return tournamentService.addTournament(tournament);
    }

    @DeleteMapping("/{id}")
    public void deleteTournament(@PathVariable int id){
        tournamentService.deleteTournamentById(id);
    }

    @PutMapping("/{id}/registeration/{reg_id}") // This from Player Entity
    public Tournament assignRegisteration(@PathVariable int id, @PathVariable int reg_id){
        Registeration reg = registerationService.getRegisterationById(reg_id);
        return tournamentService.addRegisterationById(id,reg);
    }

}

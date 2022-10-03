package com.spring.database.relationship.SpringDBRelationship.OneToManyBiDirectional.Controller;

import com.spring.database.relationship.SpringDBRelationship.OneToMany.Entity.Registration;
import com.spring.database.relationship.SpringDBRelationship.OneToMany.Service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registrations")
public class RegistrationController {
    @Autowired
    RegistrationService registrationService;

    @GetMapping // take default url.
    public List<Registration> getAllRegistration(){
        return registrationService.getAllRegistration();
    }

    @GetMapping(value = "/{id}")
    public Registration getRegistrationByID(@PathVariable("id") int ID){
        return registrationService.getRegistrationById(ID); // PathVariable Define in Controller
    }

    @PostMapping
    //@RequestMapping(method = RequestMethod.POST)
    public Registration addRegistration(@RequestBody Registration res){
        return registrationService.addRegistration(res);
    }

    @DeleteMapping("/{id}")
    public void deleteRegistration(@PathVariable int id){
        registrationService.deleteRegistrationById(id);
    }



}

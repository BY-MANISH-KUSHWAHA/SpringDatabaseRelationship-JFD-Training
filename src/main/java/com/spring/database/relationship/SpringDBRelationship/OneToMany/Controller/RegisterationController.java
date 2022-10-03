package com.spring.database.relationship.SpringDBRelationship.OneToMany.Controller;

import com.spring.database.relationship.SpringDBRelationship.OneToMany.Entity.Registeration;
import com.spring.database.relationship.SpringDBRelationship.OneToMany.Service.RegisterationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registerations")
public class RegisterationController {
    @Autowired
    RegisterationService registerationService;

    @GetMapping // take default url.
    public List<Registeration> getAllRegisteration(){
        return registerationService.getAllRegisteration();
    }

    @GetMapping(value = "/{id}")
    public Registeration getRegisterationByID(@PathVariable("id") int ID){
        return registerationService.getRegisterationById(ID); // PathVariable Define in Controller
    }

    @PostMapping
    //@RequestMapping(method = RequestMethod.POST)
    public Registeration addRegisteration(@RequestBody Registeration res){
        return registerationService.addRegisteration(res);
    }

    @DeleteMapping("/{id}")
    public void deleteRegisteration(@PathVariable int id){
        registerationService.deleteRegisterationById(id);
    }



}

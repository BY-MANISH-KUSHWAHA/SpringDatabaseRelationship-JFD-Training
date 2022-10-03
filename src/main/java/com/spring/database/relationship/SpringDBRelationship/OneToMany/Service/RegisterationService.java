package com.spring.database.relationship.SpringDBRelationship.OneToMany.Service;


import com.spring.database.relationship.SpringDBRelationship.OneToMany.Entity.Registeration;
import com.spring.database.relationship.SpringDBRelationship.OneToMany.Repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterationService {

    @Autowired
    private RegistrationRepository registerationRepository;

    public List<Registeration> getAllRegisteration(){
        return registerationRepository.findAll();
    }

    public Registeration getRegisterationById(int id){
        return registerationRepository.findById(id).get();
    }

    public Registeration addRegisteration(Registeration registeration){
        return registerationRepository.save(registeration);
    }

    public void deleteRegisterationById(int id){
        registerationRepository.deleteById(id);
    }



}

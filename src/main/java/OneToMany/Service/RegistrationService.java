package OneToMany.Service;


import OneToMany.Entity.Registration;
import OneToMany.Repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    public List<Registration> getAllRegistration(){
        return registrationRepository.findAll();
    }

    public Registration getRegistrationById(int id){
        return registrationRepository.findById(id).get();
    }

    public Registration addRegistration(Registration registration){
        return registrationRepository.save(registration);
    }

    public void deleteRegistrationById(int id){
        registrationRepository.deleteById(id);
    }



}

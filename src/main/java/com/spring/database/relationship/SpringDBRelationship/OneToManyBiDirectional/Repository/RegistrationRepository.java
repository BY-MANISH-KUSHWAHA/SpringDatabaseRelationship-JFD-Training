package com.spring.database.relationship.SpringDBRelationship.OneToManyBiDirectional.Repository;

import com.spring.database.relationship.SpringDBRelationship.OneToMany.Entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration,Integer> {
}

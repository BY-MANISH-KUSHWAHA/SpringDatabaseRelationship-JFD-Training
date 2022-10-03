package com.spring.database.relationship.SpringDBRelationship.OneToMany.Repository;

import com.spring.database.relationship.SpringDBRelationship.OneToMany.Entity.Registeration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository<Registeration,Integer> {
}

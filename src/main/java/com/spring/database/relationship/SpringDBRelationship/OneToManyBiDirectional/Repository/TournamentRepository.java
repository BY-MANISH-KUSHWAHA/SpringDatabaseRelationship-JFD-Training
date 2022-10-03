package com.spring.database.relationship.SpringDBRelationship.OneToManyBiDirectional.Repository;

import com.spring.database.relationship.SpringDBRelationship.OneToMany.Entity.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TournamentRepository extends JpaRepository<Tournament,Integer> {
}

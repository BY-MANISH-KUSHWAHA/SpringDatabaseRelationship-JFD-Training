package com.spring.database.relationship.SpringDBRelationship.OneToOne.Repository;

import com.spring.database.relationship.SpringDBRelationship.OneToOne.Entity.Player;
import com.spring.database.relationship.SpringDBRelationship.OneToOne.Entity.PlayerProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player,Integer> {
}

package com.spring.database.relationship.SpringDBRelationship;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDbRelationshipApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDbRelationshipApplication.class, args);
	}

}




// Web Layer
//RestController => View => HTTP Methods => @Autowired Service => Method Implementations
//whenever a request shows up

// Business Layer
//Service layer => DAO Layer => Repository as Dependency Injection => Method Implementation on Service

// DAO Layer [Database Communication]
// 1. Entity => Hibernate Trying to create tables, alter tables
// 2. Repository => JAP Repository => CRUD Operation

// ONE-TO-MANY BIDIRECTIONAL
// Tournament => Registration => Player => PlayerProfile
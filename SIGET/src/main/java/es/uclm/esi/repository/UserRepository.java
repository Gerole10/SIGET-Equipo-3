package es.uclm.esi.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import es.uclm.esi.model.User;


public interface UserRepository extends MongoRepository<User, String> {
    
    User findByEmail(String email); 
    
}

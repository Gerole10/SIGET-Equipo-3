package es.uclm.esi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.uclm.esi.model.Reunion;




public interface ReunionRepository extends MongoRepository<Reunion, String> {
    
//	 Optional<User> findByUsername(String username);
//
//	  Boolean existsByUsername(String username);
//
//	  Boolean existsByEmail(String email);
//    
}
